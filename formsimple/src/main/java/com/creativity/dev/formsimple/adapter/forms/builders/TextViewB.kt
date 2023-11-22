package com.creativity.dev.formsimple.adapter.forms.builders

import android.graphics.Typeface
import android.view.View
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter
import com.creativity.dev.formsimple.model.ListDynamic

class TextViewB {

    companion object{

        fun build(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.errorMessage.visibility = View.GONE

        }

        fun buildDescriptions(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.description.text = generalList.setText.text

            holder.description.textSize = generalList.setSize.description

            holder.description.textAlignment = generalList.setAlignment.description

            holder.description.setTextColor(generalList.setColor.description)

            holder.description.visibility = generalList.setVisibility.description

            holder.description.visibility = generalList.setVisibility.description


        }

        fun buildTitle(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.title.text = generalList.setText.title

            holder.title.textSize = generalList.setSize.title

            holder.title.setTextColor(generalList.setColor.title)

            holder.title.visibility = generalList.setVisibility.title

            holder.title.textAlignment = generalList.setAlignment.text

            holder.title.visibility = generalList.setVisibility.title

        }

        fun buildLetters(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.letter.setBackgroundResource(R.drawable.circular_view)

            holder.letter.textSize = generalList.setSize.letter

            holder.letter.setTextColor(generalList.setColor.letter)
        }

        fun buildIcon(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int) {

            val generalList = list[position]

            holder.icon.setTextColor(generalList.setColor.icon)

            holder.icon.isEnabled = generalList.isAvailable

            holder.icon.textSize = generalList.setSize.icon

            holder.icon.setTypeface(holder.icon.typeface, Typeface.NORMAL)

            holder.icon.visibility =   generalList.setVisibility.icon

            holder.icon.visibility = generalList.setVisibility.icon

            holder.icon.visibility = generalList.setVisibility.icon


        }

    }
}