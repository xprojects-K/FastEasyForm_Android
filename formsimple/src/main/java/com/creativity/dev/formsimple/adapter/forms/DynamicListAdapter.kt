package com.creativity.dev.formsimple.adapter.forms

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.*
import com.example.dreamteach.listselectdinamic.utils.AlertDialogManager
import android.widget.LinearLayout
import android.app.ActivityOptions
import android.os.Bundle
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

        @SuppressLint("QueryPermissionsNeeded")
        override fun onClick(v: View) {
            val pos = layoutPosition
            val generalList = list[pos]

            val intent = Intent(mContext, generalList.activity)
            val activityExists = intent.resolveActivityInfo(mContext.packageManager, 0) != null

            when (generalList.type) {
                ListDynamic.TypeRow.ROW_ACTIVITY -> {
                    if (activityExists) {
                        val options = generalList.setAnimation
                        val bundle = if (options.intentEnter != 0 && options.intentExit != 0) {
                            ActivityOptions.makeCustomAnimation(mContext, options.intentEnter, options.intentExit).toBundle()
                        } else {
                            null
                        }
                        mContext.startActivity(intent, bundle)
                    } else {
                        AlertDialogManager.simpleAlerts(mContext, "Alert", "This activity does not exist.")
                    }
                }
                ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST,
                ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST -> {
                    if (activityExists) {

                        ListObject.eventList = this

                        val list = generalList.setList.options
                        val title = generalList.setText.title
                        val isSingle = generalList.isSingleList
                        val colorToolbar = generalList.setColor.backgroundToolbar
                        val colorTitleToolbar = generalList.setColor.titleToolbar
                        val background = generalList.setColor.backgroundContent

                        val arrayObj = ArrayList<ListObject>().apply {
                            add(ListObject().apply {
                                this.title = title
                                this.list = list
                                this.isSingle = isSingle
                                this.colorTitleToolbar = colorTitleToolbar
                                this.colorToolbar = colorToolbar
                                this.backgroundContent = background
                                this.emptyMessage = generalList.setText.emptyMessages
                                this.imageEmpty = generalList.setColor.imageEmpty
                            })
                        }
                        val bundle = Bundle().apply {
                            putSerializable(LIST_IGB, arrayObj)
                        }
                        intent.putExtra(INTERNAL_KEY, bundle)
                        mContext.startActivity(intent)
                    } else {
                        AlertDialogManager.simpleAlerts(mContext, "Alert", "Oops, an error occurred.")
                    }
                }
                ListDynamic.TypeRow.ROW_CALENDAR_HOUR,
                ListDynamic.TypeRow.ROW_CALENDAR_DAY -> {
                    if (activityExists) {

                        ListObject.eventList = this

                        val title = generalList.setText.title
                        val colorToolbar = generalList.setColor.backgroundToolbar
                        val colorTitleToolbar = generalList.setColor.titleToolbar
                        val style = generalList.setColor.styleContentHour
                        val text = generalList.setText.text
                        val dateList = generalList.setList.arrayDates
                        val background = generalList.setColor.backgroundContent

                        val obj = ColectionCalendar().apply {
                            this.title = title
                            this.styleContentHour = style
                            this.text = text
                            this.colorTitleToolbar = colorTitleToolbar
                            this.colorToolbar = colorToolbar
                            this.listDate = dateList
                            this.background = background
                            this.format = generalList.setDateFormat
                        }
                        val arrayCollection = ArrayList<ColectionCalendar>().apply {
                            add(obj)
                        }
                        val bundle = Bundle().apply {
                            putSerializable(LIST_IGB_CA, arrayCollection)
                        }
                        intent.putExtra(GeneralHelper.keyBundle(), bundle)
                        mContext.startActivity(intent)
                    } else {
                        AlertDialogManager.simpleAlerts(mContext, "Alert", "Oops, an error occurred.")
                    }
                }

                ListDynamic.TypeRow.ROW_ON_CLICK -> generalList.action()

                else -> {

                    // Default options isn't use in this moment.

                }
            }
        }

        //@Interfaces for listiner edit text user
        override fun eventEdtiText(str: String) {

            val position: Int = bindingAdapterPosition

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
            var result = false

             if(position >= 0)
               result = list[position].checked

            return result
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

            val position: Int = bindingAdapterPosition
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
            val listDynamicItem = list.getOrNull(position)

            if (viewHolder != null && listDynamicItem != null) {
                val imageError: ImageView = viewHolder.itemView.findViewById(R.id.img_selected2)
                val imageSelected: ImageView = viewHolder.itemView.findViewById(R.id.img_selected)
                val tv: TextView = viewHolder.itemView.findViewById(R.id.tv_desc_insp)
                val title: TextView = viewHolder.itemView.findViewById(R.id.tv_title_insp)

                val selectedList = inputList.filterIsInstance<Select>()

                listDynamicItem.setList.options = ArrayList(selectedList)

                if (listDynamicItem.isSingleList) {
                    val firstSelectedItem = selectedList.firstOrNull { it.check }
                    val text = firstSelectedItem?.text ?: ""

                    listDynamicItem.setImage.selected = listDynamicItem.setImage.arrow
                    imageError.setImageResource(listDynamicItem.setImage.selected)
                    tv.text = text
                    listDynamicItem.setText.text = text
                    title.setTextColor(listDynamicItem.setColor.title)
                } else if (!listDynamicItem.isSingleList && selectedList.isNotEmpty()) {
                    val text = selectedList.first().text.limitAndAppendEllipsis(20)
                    tv.text = text
                    listDynamicItem.setText.text = text
                    title.setTextColor(listDynamicItem.setColor.title)
                }

                val isCheckList = listDynamicItem.type == ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST || listDynamicItem.type == ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST
                if (isCheckList) {
                    listDynamicItem.checked = listDynamicItem.setList.options.any { it.check }
                    listDynamicItem.setImage.selected = if (listDynamicItem.checked) listDynamicItem.setImage.success else listDynamicItem.setImage.arrow
                    listDynamicItem.setText.text = ""
                    imageSelected.setImageResource(listDynamicItem.setImage.selected)
                    recyclerView.adapter?.notifyItemChanged(position)
                }

                response(position) // Response in the main activity
            }
        }

        private fun response(pos: Int) {
            if (mContext is FormsListenerIGB) {
                val isaac = ResponseFormsIGB().apply {
                    tag = list[pos].tag
                    position = pos
                    options = list[pos].setList.options
                    text = list[pos].setText.text
                    title = list[pos].setText.title
                    checked = list[pos].checked
                    iconArrow = list[pos].setImage.arrow
                    type = list[pos].type

                    if (type == ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST || type == ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST) {
                        checked = options.any { it.check }
                    }
                }
                (mContext as FormsListenerIGB).actionFormResponse(isaac)
            }
        }

    }

}
