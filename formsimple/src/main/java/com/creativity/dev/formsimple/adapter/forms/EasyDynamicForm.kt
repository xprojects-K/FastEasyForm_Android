package com.creativity.dev.formsimple.adapter.forms

import android.content.Context
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
import java.lang.Exception


// You can create a subclass that provides the implementation.
class EasyDynamicForm(model: List<ListDynamic>, mContext: Context,recyclerView: RecyclerView,positionRow: ArrayList<CollectionControlsList>) : DynamicListAdapter(model,mContext,recyclerView,positionRow) {

    override fun init(
        listMenu: List<ListDynamic>,
        mContext: Context,
        recyclerView: RecyclerView,
        positionRow: ArrayList<CollectionControlsList>
    ) {



    }
    override fun validateAll():Boolean {

        var response = true

        var isScrollMoved = false

        testOut = true

        try {

            if(positionRow.size > 0){

                positionRow.forEach {

                    val str = this.list[it.post].setText.text

                    val type = this.list[it.post].type

                    val imgError = this.list[it.post].setImage.warning

                    val viewHolder = recyclerView.findViewHolderForAdapterPosition(it.post)

                    if(type == ListDynamic.typeRow.ROW_EDIT && str.isEmpty() || type == ListDynamic.typeRow.ROW_EDIT && str == this.list[it.post].setText.emptyMessages){

                        if(!isScrollMoved){

                            isScrollMoved = true

                            recyclerView.scrollToPositionWithAnimation(it.post)

                        }

                        if (viewHolder != null) {

                            val errorMessage: TextView = viewHolder.itemView.findViewById(R.id.tv_message_error)

                            errorMessage.text = this.list[it.post].setText.emptyMessages

                            errorMessage.visibility = View.VISIBLE

                            AnimationTextView.animateVibrationTV(errorMessage,mContext)
                        }

                        response = false

                    }
                    else if(type == ListDynamic.typeRow.ROW_MULTIPLE_CHECK_LIST){

                        if (this.list[it.post].setList.options.filter { o -> o.check }.size == 0) {

                            this.list[it.post].setImage.selected = this.list[it.post].setImage.warning

                            if(!isScrollMoved){

                                isScrollMoved = true

                                recyclerView.scrollToPositionWithAnimation(it.post)

                            }

                            if(viewHolder != null ){

                                val tv: TextView = viewHolder.itemView.findViewById(R.id.tv_title_insp)

                                val imageError: ImageView = viewHolder.itemView.findViewById(R.id.img_selected2)

                                imageError.setImageResource(imgError)

                                AnimationTextView.animateVibrationTV(tv,mContext)

                            }

                            response = false

                        }

                    }
                    else if (str.isEmpty()) {

                        if(!isScrollMoved){

                            isScrollMoved = true

                            recyclerView.scrollToPositionWithAnimation(it.post)

                        }

                        if (viewHolder != null) {

                            val tv: TextView = viewHolder.itemView.findViewById(R.id.tv_title_insp)

                            val imageError: ImageView = viewHolder.itemView.findViewById(R.id.img_selected2)

                            this.list[it.post].setImage.selected = this.list[it.post].setImage.warning

                            imageError.setImageResource(imgError)

                            AnimationTextView.animateVibrationTV(tv,mContext)


                        }

                        response = false
                    }

                }
            }else{
                response = false
            }


        }catch (ex: Exception){

            response = false

        }

        return response

    }
    override fun validateByTag(tag: String):Boolean {

        var response = true

        var isScrollMoved = false

        testOut = true

        try {

            if(positionRow.size > 0){

                positionRow.forEach {

                    val setTag = this.list[it.post].tag

                    if(setTag == tag){

                        val str = this.list[it.post].setText.text

                        val type = this.list[it.post].type

                        val imgError = this.list[it.post].setImage.warning

                        val viewHolder = recyclerView.findViewHolderForAdapterPosition(it.post)

                        if(type == ListDynamic.typeRow.ROW_EDIT && str.isEmpty() || type == ListDynamic.typeRow.ROW_EDIT && str == this.list[it.post].setText.emptyMessages){

                            if(!isScrollMoved){

                                isScrollMoved = true

                                recyclerView.scrollToPositionWithAnimation(it.post)

                            }

                            if (viewHolder != null) {

                                val errorMessage: TextView = viewHolder.itemView.findViewById(R.id.tv_message_error)

                                errorMessage.text = this.list[it.post].setText.emptyMessages

                                errorMessage.visibility = View.VISIBLE

                                AnimationTextView.animateVibrationTV(errorMessage,mContext)
                            }

                            response = false

                        }
                        else if(type == ListDynamic.typeRow.ROW_MULTIPLE_CHECK_LIST){

                            if (this.list[it.post].setList.options.filter { o -> o.check }.size == 0) {

                                this.list[it.post].setImage.selected = this.list[it.post].setImage.warning

                                if(!isScrollMoved){

                                    isScrollMoved = true

                                    recyclerView.scrollToPositionWithAnimation(it.post)

                                }

                                if(viewHolder != null ){

                                    val tv: TextView = viewHolder.itemView.findViewById(R.id.tv_title_insp)

                                    val imageError: ImageView = viewHolder.itemView.findViewById(R.id.img_selected2)

                                    imageError.setImageResource(imgError)

                                    AnimationTextView.animateVibrationTV(tv,mContext)

                                }

                                response = false

                            }

                        }
                        else if (str.isEmpty()) {

                            if(!isScrollMoved){

                                isScrollMoved = true

                                recyclerView.scrollToPositionWithAnimation(it.post)

                            }

                            if (viewHolder != null) {

                                val tv: TextView = viewHolder.itemView.findViewById(R.id.tv_title_insp)

                                val imageError: ImageView = viewHolder.itemView.findViewById(R.id.img_selected2)

                                this.list[it.post].setImage.selected = this.list[it.post].setImage.warning

                                imageError.setImageResource(imgError)

                                AnimationTextView.animateVibrationTV(tv,mContext)


                            }

                            response = false
                        }

                        return@forEach

                    }


                }
            }else{
                response = false
            }


        }catch (ex: Exception){

            response = false

        }

        return response

    }
    override fun getResultByTag(tag: String): ResponseFormsIGB {

        val obj = ResponseFormsIGB()

        list.forEachIndexed { index, listDynamic ->

            if(listDynamic.type != ListDynamic.typeRow.ROW_TITLE && listDynamic.tag == tag){

                obj.tag = listDynamic.tag

                obj.text = listDynamic.setText.text

                obj.position = index

                obj.checked = listDynamic.checked

                obj.options = listDynamic.setList.options

                obj.type = listDynamic.type

                return@forEachIndexed
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

        var view: View
        var tv: TextView
        var image: ImageView
        var editText: EditText
        var success = false

       try {

           list.forEachIndexed { index, listDynamic ->

               if(listDynamic.type != ListDynamic.typeRow.ROW_TITLE && listDynamic.tag == tagOrTitle){

                   list[index].setImage.selected = eventChecked(objRespIGB.checked,index )

                   if (objRespIGB.options.size > 0)
                       list[index].setList.options =  objRespIGB.options

                   if (objRespIGB.text.isNotEmpty())
                       list[index].setText.text = objRespIGB.text

                   view = recyclerView.findViewHolderForAdapterPosition(index)!!.itemView
                   tv = view.findViewById(R.id.tv_desc_insp)
                   image = view.findViewById(R.id.img_selected)
                   editText = view.findViewById(R.id.edt_text)

                   tv.text = list[index].setText.text
                   editText.setText(list[index].setText.text)

                   if(listDynamic.type == ListDynamic.typeRow.ROW_CHECK){

                       val shake = AnimationUtils.loadAnimation(mContext,R.anim.zoom_in)

                       image.setBackgroundResource(list[index].setImage.selected)

                       image.startAnimation(shake)

                   }

                   success = true

                   return@forEachIndexed
               }

           }

       } catch (_: Exception){

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

}

