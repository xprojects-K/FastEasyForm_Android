package com.creativity.dev.formsimple.model

import com.creativity.dev.formsimple.types.ROW_CHECK
import java.io.Serializable
import java.util.Date


class ResponseFormsIGB:Serializable{

    //<Identifier>
    var tag: String = ""
    var position: Int = 0
    var date: Date = Date()
    //</>

    //<Content>
    var text: String = ""
    var checked: Boolean = false
    var options: ArrayList<Select> = ArrayList()
    lateinit  var type: ListDynamic.typeRow
    //</>
}

inline fun SetRow(obj: ResponseFormsIGB.() -> Unit): ResponseFormsIGB {
    val newList = ResponseFormsIGB()
    newList.obj()
    return newList
}