package com.creativity.dev.formsimple.adapter.forms

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.ext.scrollToPositionWithAnimation
import com.creativity.dev.formsimple.model.CollectionControlsList
import com.creativity.dev.formsimple.model.ListDynamic
import com.creativity.dev.formsimple.model.ResponseFormsIGB
import com.jgb.lordsaac.igb.supportanimation.AnimationTextView


// You can create a subclass that provides the implementation.
class EasyDynamicForm(model: List<ListDynamic>, mContext: Context,recyclerView: RecyclerView,positionRow: ArrayList<CollectionControlsList>) : DynamicListAdapter(model,mContext,recyclerView,positionRow) {

    override fun init(
        listMenu: List<ListDynamic>,
        mContext: Context,
        recyclerView: RecyclerView,
        positionRow: ArrayList<CollectionControlsList>
    ) {



    }

    override fun getDataResponse(str: String?) {
        // This function is currently empty as it serves as a placeholder.
        // Depending on the context or requirements, data retrieval or processing logic
        // related to the received string parameter 'str' can be implemented here.
        // As of now, it does not contain any specific functionality.
    }
    override fun validateAll(): Boolean {

        var response = true

        try {
            positionRow.forEach { position ->

                val row = this.list[position.post]
                val str = row.setText.text
                val type = row.type
                val isValidation = row.validation
                val imgError = row.setImage.warning
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(position.post)
                var isScrollMoved = false

                if(isValidation){

                    when {
                        (type == ListDynamic.TypeRow.ROW_EDIT && (str.isEmpty() || str == row.setText.emptyMessages)) -> {


                            recyclerView.scrollToPositionWithAnimation(position.post)
                            handleErrorMessageEditText(viewHolder, imgError, mContext)
                            response = false
                        }
                        ( (type == ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST || type == ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST))  && row.setList.options.none { it.check } -> {

                            this.list[position.post].setImage.selected = this.list[position.post].setImage.warning

                            recyclerView.scrollToPositionWithAnimation(position.post)
                            handleMultipleCheckError(viewHolder, imgError, mContext)
                            response = false
                        }
                        ( type == ListDynamic.TypeRow.ROW_CHECK) && !row.checked-> {

                            recyclerView.scrollToPositionWithAnimation(position.post)

                            handleMultipleCheckError(viewHolder, imgError, mContext)

                            response = false
                        }
                        (type != ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST) && type != ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST && type != ListDynamic.TypeRow.ROW_CHECK && str.isEmpty() -> {
                            recyclerView.scrollToPositionWithAnimation(position.post)
                            handleMultipleCheckError(viewHolder, imgError, mContext)
                            response = false
                        }

                    }

                }

            }

            if (positionRow.isEmpty()) {

                response = false

            }

        } catch (ex: Exception) {

            response = false

        }

        return response
    }
    @SuppressLint("SuspiciousIndentation")
    override fun validateByTag(tag: String): Boolean {

        try {

        var scrollMove = false
        val row = this.list.firstOrNull { m -> m.tag == tag && m.validation }
        val position = this.list.indexOf(row)

                if (row != null ) {

                    val str = row.setText.text
                    val type = row.type
                    val imgError = row.setImage.warning
                    val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)

                    when {
                        (type == ListDynamic.TypeRow.ROW_EDIT && (str.isEmpty() || str == row.setText.emptyMessages)) -> {

                            scrollMove = true
                            handleErrorMessageEditText(viewHolder, imgError, mContext)

                        }
                        ((type == ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST || type == ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST) && row.setList.options.none { it.check }) -> {

                            scrollMove = true

                            row.setImage.selected = imgError

                            list[position].setImage.selected = this.list[position].setImage.warning

                            handleErrorMessage(viewHolder, imgError, mContext)
                        }
                        (type == ListDynamic.TypeRow.ROW_CHECK)  && !row.checked-> {

                            handleMultipleCheckError(viewHolder, imgError, mContext)

                            scrollMove = true
                        }
                        (type != ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST) && type != ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST && type != ListDynamic.TypeRow.ROW_CHECK  && str.isEmpty() -> {

                            scrollMove = true

                            row.setImage.selected = imgError

                            handleErrorMessage(viewHolder, imgError, mContext)
                        }

                    }

                    if (scrollMove){

                        recyclerView.scrollToPositionWithAnimation(position)

                        return false
                    }

                    return true

                }else{

                    return false

                }

        } catch (ex: Exception) {

            return false

        }

    }
    override fun getResultByTag(tag: String): ResponseFormsIGB {

        val obj: ResponseFormsIGB = ResponseFormsIGB()

        val listDynamic = this.list.firstOrNull { m -> m.tag == tag}

        if(listDynamic != null){

            obj.tag = listDynamic.tag

            obj.text = listDynamic.setText.text

            obj.position = this.list.indexOf(listDynamic)

            obj.checked = listDynamic.checked

            obj.options = listDynamic.setList.options

            obj.type = listDynamic.type

            obj.title = listDynamic.setText.title

            obj.iconArrow = listDynamic.setImage.selected

            if(obj.type == ListDynamic.TypeRow.ROW_SINGLE_CHECK_LIST || obj.type == ListDynamic.TypeRow.ROW_MULTIPLE_CHECK_LIST){

                if(obj.options.count { select -> select.check } > 0){

                    obj.checked = true

                }

            }

        }

        return obj

    }
    override fun getResultAll():ArrayList<ResponseFormsIGB> {

        val result = ArrayList<ResponseFormsIGB>()

        list.forEachIndexed { index, listDynamic ->

            val obj = ResponseFormsIGB()

            obj.tag = listDynamic.tag

            obj.text = listDynamic.setText.text

            obj.position = index

            obj.checked = listDynamic.checked

            obj.options = listDynamic.setList.options

            obj.type = listDynamic.type

            obj.iconArrow = listDynamic.setImage.selected

            obj.title = listDynamic.setText.title

            result.add(obj)

        }

        return result

    }
    override fun getResults(tag: String): List<ResponseFormsIGB>{

        val objList :ArrayList<ResponseFormsIGB> = ArrayList()

        list.forEachIndexed { index, listDynamic ->

            val obj: ResponseFormsIGB = ResponseFormsIGB()

            obj.tag = listDynamic.tag

            obj.text = listDynamic.setText.text

            obj.position = index

            obj.checked = listDynamic.checked

            obj.options = listDynamic.setList.options

            obj.type = listDynamic.type

            objList.add(obj)

        }

        return objList

    }
    override fun updateRow(tagOrTitle: String,objRespIGB: ResponseFormsIGB): Boolean{

        val view: View
        val tv: TextView
        val title: TextView
        val image: ImageView
        val editText: EditText
        var success = false
        val listDynamic = this.list.firstOrNull { m -> m.tag == tagOrTitle}

       try {

           if(listDynamic != null){

                   val index = this.list.indexOf(listDynamic)

                   if (objRespIGB.options.size > 0)
                       list[index].setList.options =  objRespIGB.options

                   if (objRespIGB.text.isNotEmpty())
                       list[index].setText.text = objRespIGB.text

                   list[index].setText.title = objRespIGB.title

                   list[index].setText.text = objRespIGB.text

                   view = recyclerView.findViewHolderForAdapterPosition(index)!!.itemView

                   tv = view.findViewById(R.id.tv_desc_insp)

                   title = view.findViewById(R.id.tv_title_insp)

                   image = view.findViewById(R.id.img_selected)

                   editText = view.findViewById(R.id.edt_text)

                   tv.text = list[index].setText.text

                   title.text = list[index].setText.title

                   editText.setText(list[index].setText.text)

                   if(listDynamic.type == ListDynamic.TypeRow.ROW_CHECK){

                       val shake = AnimationUtils.loadAnimation(mContext,R.anim.zoom_in)

                       list[index].setImage.selected = eventChecked(objRespIGB.checked,index )

                       list[index].setImage.selected = objRespIGB.iconSelected

                       image.setBackgroundResource(list[index].setImage.selected)

                       image.startAnimation(shake)

                   }

                   this.recyclerView.scrollToPosition(objRespIGB.position)

                   this.recyclerView.adapter?.notifyItemChanged(objRespIGB.position)

                   this.recyclerView.scrollToPositionWithAnimation(index)

                   success = true


           }else{

               success = false

           }


       } catch (ex: Exception){

           success = false

       }

       return success

    }
    override fun eventChecked(isSelected: Boolean , position: Int):Int {

        val position: Int = position

        var imageSelected = 0

        list[position].checked = isSelected

        imageSelected = if(isSelected)
            list[position].setImage.checkedSelected
        else
            list[position].setImage.checkedDiselected

        list[position].setImage.selected = imageSelected

        return imageSelected
    }
    private fun handleErrorMessage( viewHolder: RecyclerView.ViewHolder?, imgError: Int, context: Context) {

        viewHolder?.let {
            val tv: TextView = it.itemView.findViewById(R.id.tv_title_insp)
            val imageError: ImageView = it.itemView.findViewById(R.id.img_selected2)

            imageError.setImageResource(imgError)
            AnimationTextView.animateVibrationTV(tv, context)
        }
    }
    private fun handleErrorMessageEditText( viewHolder: RecyclerView.ViewHolder?, imgError: Int, context: Context) {

        viewHolder?.let {

            val errorMessage: TextView = viewHolder.itemView.findViewById(R.id.tv_message_error)
            val imageError: ImageView = it.itemView.findViewById(R.id.img_selected2)

            errorMessage.text = this.list[it.layoutPosition].setText.emptyMessages

            errorMessage.visibility = View.VISIBLE

            imageError.setImageResource(imgError)
            AnimationTextView.animateVibrationTV(errorMessage, context)

        }
    }
    private fun handleMultipleCheckError(viewHolder: RecyclerView.ViewHolder?, imgError: Int, context: Context) {

        viewHolder?.let {
            val tv: TextView = it.itemView.findViewById(R.id.tv_title_insp)
            val imageError: ImageView = it.itemView.findViewById(R.id.img_selected2)
            imageError.setImageResource(imgError)
            AnimationTextView.animateVibrationTV(tv, context)
        }
    }
}

