package com.creativity.dev.formsimple.adapter.forms

import android.content.Context
import android.content.Intent
import android.widget.*
import com.example.dreamteach.listselectdinamic.utils.AlertDialogManager
import android.widget.LinearLayout
import android.app.ActivityOptions
import android.view.*
import android.widget.TextView
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.interfaces.DelegateDialogAlert
import com.creativity.dev.formsimple.ui.INTERNAL_KEY
import com.creativity.dev.formsimple.ui.LIST_IGB

import com.creativity.dev.formsimple.extensions.eventImageCheckBoxDynamic
import com.creativity.dev.formsimple.extensions.eventWriten
import com.creativity.dev.formsimple.interfaces.EventList
import com.creativity.dev.formsimple.interfaces.EventListDynamic

import kotlin.collections.ArrayList
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.adapter.forms.Interfaces.DynamicListAdapterI
import com.creativity.dev.formsimple.adapter.forms.builders.CheckButtonB
import com.creativity.dev.formsimple.adapter.forms.builders.EditTextB
import com.creativity.dev.formsimple.adapter.forms.builders.ImageViewB
import com.creativity.dev.formsimple.adapter.forms.builders.LinearLayoutB
import com.creativity.dev.formsimple.adapter.forms.builders.TextViewB
import com.creativity.dev.formsimple.ext.limitAndAppendEllipsis
import com.creativity.dev.formsimple.ui.LIST_IGB_CA
import com.creativity.dev.formsimple.interfaces.FormsListenerIGB
import com.creativity.dev.formsimple.model.*
import com.creativity.dev.formsimple.types.ROW_SINGLE_CHECK_LIST
import com.creativity.dev.formsimple.utils.GeneralHelper

import com.google.android.material.textfield.TextInputLayout


//https://stackoverflow.com/questions/39346343/java-equivalent-of-c-sharp-delegates-queues-methods-of-various-classes-to-be-ex
//@Autor: José I. Gutiérrez B.
//@Year: 2018

abstract class DynamicListAdapter (model: List<ListDynamic>, mContext: Context,recyclerView: RecyclerView,positionRow: ArrayList<CollectionControlsList>): RecyclerView.Adapter<DynamicListAdapter.DynamicListHolder>(), DelegateDialogAlert,
    DynamicListAdapterI {

     val mContext: Context = mContext

     var list: List<ListDynamic> = model

     val recyclerView: RecyclerView = recyclerView

     var testOut: Boolean = false

     val positionRow: ArrayList<CollectionControlsList> = positionRow

     abstract fun init(listMenu: List<ListDynamic>, mContext: Context,recyclerView: RecyclerView,positionRow: ArrayList<CollectionControlsList>)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicListHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_check_list, parent, false)

        return DynamicListHolder(itemView)
    }

    override fun onBindViewHolder(holder: DynamicListHolder, position: Int) {

        TextViewB.build(holder,list,position)

        TextViewB.buildDescriptions(holder,list,position)

        TextViewB.buildIcon(holder,list,position)

        TextViewB.buildTitle(holder,list,position)

        TextViewB.buildLetters(holder,list,position)

        EditTextB.build(holder,list,position)

        CheckButtonB.build(holder,list,position)

        LinearLayoutB.build(holder,list,position)

        LinearLayoutB.buildSeparator(holder,list,position)

        ImageViewB.build(holder,list,position)

    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun getDataResponse(str: String) {

    }

    inner class DynamicListHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, EventListDynamic, EventList {

        var title: TextView
        var letter: TextView
        var errorMessage: TextView
        var icon: TextView
        var editText: EditText
        var description: TextView
        var check: CheckBox
        var contentLetter: RelativeLayout
        var content: LinearLayout
        var UnvContent: LinearLayout
        var contentImg: LinearLayout
        var seperatorContent: LinearLayout
        var styleEditText: TextInputLayout
        var img: ImageView
        var img2: ImageView

        init {

            title = view.findViewById(R.id.tv_title_insp)
            icon = view.findViewById(R.id.tv_icon_insp)
            description = view.findViewById(R.id.tv_desc_insp)
            check = view.findViewById(R.id.ck_selected_insp)
            letter = view.findViewById(R.id.tv_letters_inps)
            content = view.findViewById(R.id.lyt_content_obj)
            contentLetter = view.findViewById(R.id.rl_letter_content)
            UnvContent = view.findViewById(R.id.ly_unv_content)
            contentImg = view.findViewById(R.id.conten_img_selected)
            seperatorContent = view.findViewById(R.id.ly_separator)
            editText = view.findViewById(R.id.edt_text)
            styleEditText = view.findViewById(R.id.style2)
            img = view.findViewById(R.id.img_selected);
            img2 = view.findViewById(R.id.img_selected2);
            errorMessage = view.findViewById(R.id.tv_message_error);

            content.setOnClickListener(this)

            img2.setOnClickListener(this)

            editText.eventWriten(this)

            contentImg.eventImageCheckBoxDynamic(this,img)

        }

        override fun onClick(v: View) {

            val pos = layoutPosition

            val generalList = list[pos]

            if(generalList.type == ListDynamic.typeRow.ROW_ACTIVITY){

                val intent = Intent(mContext, generalList.activity)

                val activityExists = intent.resolveActivityInfo(mContext.packageManager, 0) != null

                if (activityExists) run {

                    if(generalList.setAnimation.intentEnter != 0 && generalList.setAnimation.intentExit != 0){

                        generalList.bundleActivity = ActivityOptions.makeCustomAnimation(mContext, generalList.setAnimation.intentEnter, generalList.setAnimation.intentExit).toBundle()

                        mContext.startActivity(intent, generalList.bundleActivity)

                    }else{

                        mContext.startActivity(intent,generalList.bundleActivity)

                    }

                }else{

                    AlertDialogManager.simpleAlerts(mContext,"Alert","This activity not exist.")

                }

            }
            else if(generalList.type == ListDynamic.typeRow.ROW_MULTIPLE_CHECK_LIST || generalList.type == ListDynamic.typeRow.ROW_SINGLE_CHECK_LIST){

                val intent = Intent(mContext, generalList.activity)
                val bundle = generalList.bundleActivity
                val list = generalList.setList.options
                val title: String = generalList.setText.title
                val isSingle: Boolean = generalList.isSingleList
                val colorToolbar: Int = generalList.setColor.backgroundToolbar
                val colorTitleToolbar: Int = generalList.setColor.titleToolbar
                val background: Int = generalList.setColor.backgroundContent
                val arrayObj:  ArrayList<ListObject> = ArrayList()
                val obj = ListObject()
                val emptyMessage = generalList.setText.emptyMessages
                val imageEmpty = generalList.setColor.imageEmpty

                val activityExists = intent.resolveActivityInfo(mContext.packageManager, 0) != null

                if (activityExists) run {

                        obj.title = title
                        obj.list = list
                        obj.isSingle = isSingle
                        obj.colorTitleToolbar = colorTitleToolbar
                        obj.colorToolbar = colorToolbar
                        obj.backgroundContent = background
                        obj.emptyMessage = emptyMessage
                        obj.imageEmpty = imageEmpty

                        ListObject.eventList = this

                        arrayObj.add(obj)

                        bundle.putSerializable(LIST_IGB,arrayObj)

                        intent.putExtra(INTERNAL_KEY,bundle)

                        mContext.startActivity(intent)

                }else{

                    AlertDialogManager.simpleAlerts(mContext,"Alert","ups ocurred a problem :(")

                }

            }
            else if(generalList.type == ListDynamic.typeRow.ROW_CALENDAR_HOUR || generalList.type == ListDynamic.typeRow.ROW_CALENDAR_DAY){

                val intent = Intent(mContext, generalList.activity)
                val bundle = generalList.bundleActivity
                val title: String = generalList.setText.title
                val colorToolbar: Int = generalList.setColor.backgroundToolbar
                val colorTitleToolbar: Int = generalList.setColor.titleToolbar
                val style: Int = generalList.setColor.styleContentHour
                val text: String = generalList.setText.text
                val obj = ColectionCalendar()
                val arrayCollection: ArrayList<ColectionCalendar> = ArrayList()
                val dateList = generalList.setList.arrayDates
                val background = generalList.setColor.backgroundContent
                val activityExists = intent.resolveActivityInfo(mContext.packageManager, 0) != null

                if (activityExists) run {

                    obj.title = title
                    obj.styleContentHour = style
                    obj.text = text
                    obj.colorTitleToolbar = colorTitleToolbar
                    obj.colorToolbar = colorToolbar
                    obj.listDate = dateList
                    obj.background = background
                    obj.format = generalList.setDateFormat

                    arrayCollection.add(obj)
                    ListObject.eventList = this

                    bundle.putSerializable(LIST_IGB_CA,arrayCollection)

                    intent.putExtra(GeneralHelper.keyBundle(),bundle)
                    mContext.startActivity(intent)

                }else{

                    AlertDialogManager.simpleAlerts(mContext,"Alert","ups ocurred a problem :(")

                }
            }
            else if(generalList.type == ListDynamic.typeRow.ROW_ON_CLICK){

                if(generalList.action != null){

                    generalList.action()

                }

            }

        }

        //@Interfaces for listiner edit text user
        override fun eventEdtiText(str: String) {

            val position: Int = adapterPosition

            val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)

            list[position].setText.text = str

            if (viewHolder != null) {
                viewHolder.itemView.findViewById<TextView?>(R.id.tv_message_error).visibility = View.GONE
            }

          //   response(position) // <-- Response in the mein activity Aqui
        }

        //@Interfaces for listiner edit text user
        override fun eventChecked(isSelected: Boolean):Int {

            val position: Int = layoutPosition

            var imageSelected = 0

            list[position].checked = isSelected

            imageSelected = if(isSelected)
                list[position].setImage.checkedSelected
            else
                list[position].setImage.checkedDiselected

            list[position].setImage.selected = imageSelected

            response(position) // <-- Response in the mein activity

            return imageSelected
        }

        //@Interfaces Here listener get, the now check
        override fun getSelected(): Boolean {

            val position: Int = layoutPosition

            return if(position >= 0)
                list[position].checked
            else
                false
        }

        override fun evenSetSimpleString(str: String) {

            val position: Int = layoutPosition

            val view = recyclerView.findViewHolderForAdapterPosition(position)!!.itemView

            if(str.isNotEmpty()){

                val tv: TextView = view.findViewById(R.id.tv_desc_insp)

                val tittle: TextView = view.findViewById(R.id.tv_title_insp)

                val imageError: ImageView = view.findViewById(R.id.img_selected2)

                list[position].setImage.selected = list[position].setImage.arrow

                imageError.setImageResource(list[position].setImage.selected)

                tv.text = str
                list[position].setText.text = str
                tittle.setTextColor(list[position].setColor.title)
                response(position) // <-- Response in the mein activity
            }

        }

        override fun eventSetList(inputList: List<Any>) {

            val position: Int = adapterPosition

            val view = recyclerView.findViewHolderForAdapterPosition(position)!!.itemView

            val imageError: ImageView = view.findViewById(R.id.img_selected2)

            val imageSelected: ImageView = view.findViewById(R.id.img_selected)

            val tv: TextView = view.findViewById(R.id.tv_desc_insp)

            val tittle: TextView = view.findViewById(R.id.tv_title_insp)

            list[position].setList.options = inputList as ArrayList<Select>

            if(list[position].isSingleList && inputList.isNotEmpty()){

                val newList: ArrayList<Select> = inputList.filter { it.check } as  ArrayList<Select>

                var text:String = ""

                list[position].setImage.selected = list[position].setImage.arrow

                imageError.setImageResource(list[position].setImage.selected)
                
                if(newList.size > 0){
                    text = newList[0].text
                    tv.text = text
                    tittle.setTextColor(list[position].setColor.title)
                    list[position].setText.text = text

                }else{
                    tv.text = text
                    list[position].setText.text = text
                }

            }
            else if(!list[position].isSingleList && inputList.isNotEmpty()){

                val newList: ArrayList<Select> = inputList.filter { it.check } as  ArrayList<Select>

                var text:String = ""

                if(newList.size > 0){

                    text = newList[0].text.limitAndAppendEllipsis(20)

                    tv.text = text

                    tittle.setTextColor(list[position].setColor.title)

                    list[position].setText.text = text

                }

            }

            if(list[position].setList.options.filter { it.check }.isNotEmpty()){

                list[position].setImage.selected = list[position].setImage.arrow

                imageError.setImageResource(list[position].setImage.selected)
            }

            if(list[position].setting.rowMultipleCheck.activeIconSuccess ||list[position].setting.rowSingleCheck.activeIconSuccess ){

                if(list[position].type == ListDynamic.typeRow.ROW_SINGLE_CHECK_LIST || list[position].type == ListDynamic.typeRow.ROW_MULTIPLE_CHECK_LIST) {


                    if( list[position].setList.options.count { select -> select.check } > 0){

                        list[position].checked = true

                        list[position].setImage.selected =  list[position].setImage.success

                    }else{

                        list[position].checked = false

                        list[position].setImage.selected =  list[position].setImage.arrow

                    }

                    list[position].setText.text = ""

                    imageSelected.setImageResource(list[position].setImage.selected)

                    recyclerView.adapter!!.notifyItemChanged(position)

                }


            }

            response(position) // <-- Response in the mein activity
        }

        private fun response(pos:Int){

            if(mContext is FormsListenerIGB){

                val delegateMain: FormsListenerIGB = mContext as FormsListenerIGB

                val isaac = ResponseFormsIGB() //<--a little reference for here

                isaac.tag = list[pos].tag
                isaac.position = pos
                isaac.options = list[pos].setList.options
                isaac.text = list[pos].setText.text
                isaac.title = list[pos].setText.title
                isaac.checked = list[pos].checked
                isaac.iconArrow = list[pos].setImage.arrow
                isaac.type =  list[pos].type

                if(isaac.type == ListDynamic.typeRow.ROW_SINGLE_CHECK_LIST || isaac.type == ListDynamic.typeRow.ROW_MULTIPLE_CHECK_LIST){

                    if(isaac.options.count { select -> select.check } > 0){

                        isaac.checked = true

                    }

                }

                delegateMain.actionFormResponse(isaac)

            }
        }

    }

}
