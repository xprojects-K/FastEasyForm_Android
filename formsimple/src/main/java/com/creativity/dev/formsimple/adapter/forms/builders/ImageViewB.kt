package com.creativity.dev.formsimple.adapter.forms.builders

import com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter
import com.creativity.dev.formsimple.model.ListDynamic

class ImageViewB {


    companion object {

        fun build(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.img.visibility = generalList.setVisibility.imgContentEnable

            holder.img.setImageResource(generalList.setImage.selected)

            holder.img2.visibility = generalList.setVisibility.imgContentEnable2

            holder.img2.setImageResource(generalList.setImage.selected)

        }
    }
}