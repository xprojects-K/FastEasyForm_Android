package com.creativity.dev.formsimple

import com.creativity.dev.formsimple.model.ListDynamic
import com.creativity.dev.formsimple.model.Select
import com.creativity.dev.formsimple.types.ROW_CHECK
import com.creativity.dev.formsimple.types.ROW_EDIT
import java.io.Serializable

//Autor: José I. Gutiérrez B.
//Year: 2018

class BuilderForms:Serializable{

    companion object {

        var list: ArrayList<ListDynamic> = ArrayList()

        var options: java.util.ArrayList<Select> = ArrayList()

    }

}

// The primary purpose of using Unit as the return type of a function is to indicate that the function doesn't return any meaningful result or value. Here are some common scenarios where you might use Unit:

inline fun Row(type: Int, obj: ListDynamic.() -> Unit): ListDynamic {

    // Initialize the model object

    val newList = ListDynamic(type)

    // Initialize the obj into the object.

    newList.obj()

    // Set image if the rows is type check.

    if(newList.checked && type == ROW_CHECK){

        newList.setImage.selected = newList.setImage.checkedSelected

    }

    BuilderForms.list.add(newList)

    return newList
}

inline fun option(obj: Select.() -> Unit) {

    // Initialize the model object

    val newList = Select()

    // Initialize the obj into the object.

    newList.obj()

    BuilderForms.options.add(newList)

}