package com.creativity.dev.formsimple.adapter.forms.builders

import android.app.Activity
import com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter
import com.creativity.dev.formsimple.model.ListDynamic

class LinearLayoutB {

    companion object{

        fun build(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            val contentPaddingLeft = generalList.setPadding.content.left

            val contentPaddingRigth = generalList.setPadding.content.rigth

            val contentPaddingTop = generalList.setPadding.content.top

            val contentMarginTop: Int = generalList.setMargin.content.top

            val contentPaddingBottom = generalList.setPadding.content.bottom

            val height = (holder.content.context as Activity).windowManager.defaultDisplay.height + 80

            val sizeHeigthLny: Int = (height * generalList.setSize.row.heigth).toInt()

            holder.UnvContent.gravity = generalList.universalContentGravity

            holder.contentImg.visibility = generalList.setVisibility.check

            holder.contentImg.isEnabled = generalList.isEndableImageSelected

            holder.content.setPadding(contentPaddingLeft,contentPaddingTop,contentPaddingRigth,contentPaddingBottom)

            holder.content.layoutParams.height = sizeHeigthLny

        }


        fun buildSeparator(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.seperatorContent.setBackgroundColor(generalList.setColor.seperator)

            holder.seperatorContent.visibility = generalList.setVisibility.separator

        }

    }
}