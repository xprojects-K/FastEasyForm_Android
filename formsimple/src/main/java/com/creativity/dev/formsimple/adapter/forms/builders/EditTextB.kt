package com.creativity.dev.formsimple.adapter.forms.builders

import android.text.InputFilter
import android.view.View
import android.view.inputmethod.EditorInfo
import com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter
import com.creativity.dev.formsimple.model.ListDynamic

class EditTextB {

    companion object{

        fun build(holder: DynamicListAdapter.DynamicListHolder, list: List<ListDynamic>, position: Int){

            val generalList = list[position]

            val next = if(list.size - 1 == position) 0 else position + 1

            val isNextEditable = (list[next].type == ListDynamic.typeRow.ROW_EDIT)

            holder.editText.visibility = View.GONE

            holder.styleEditText.visibility = View.GONE

            holder.editText.visibility = generalList.setVisibility.editText

            holder.styleEditText.visibility = generalList.setVisibility.styleEdit

            holder.editText.textSize = generalList.setSize.edit

            holder.editText.setText(generalList.setText.text)

            holder.editText.inputType = generalList.inputTypeEditText

            holder.editText.isEnabled = generalList.setEditText.isEditable

            if(!isNextEditable)
                holder.editText.imeOptions = EditorInfo.IME_ACTION_DONE;

            holder.editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(generalList.maxLength)) // the position is the key

            holder.editText.setTextColor(generalList.setColor.edit)

            holder.styleEditText.hint = generalList.setText.title

            holder.styleEditText.setHintTextAppearance(generalList.setColor.editStyle)

            holder.styleEditText.hint = generalList.setText.title

        }

    }

}