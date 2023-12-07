package com.example.dreamteach.listselectdinamic.IGBDynamicList

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.BuilderForms
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.adapter.forms.EasyDynamicForm
import com.creativity.dev.formsimple.adapter.forms.DynamicListAdapter
import com.creativity.dev.formsimple.compose.EasyFormWrapper
import com.creativity.dev.formsimple.model.CollectionControlsList
import com.creativity.dev.formsimple.model.ListDynamic

class EasyForm(context: Context) {

    private var list:ArrayList<ListDynamic> = BuilderForms.list

    private val easyWrapper = EasyFormWrapper(context)

    private var context: Context = context

    private var recyclerView:RecyclerView = easyWrapper.rv()

    private val validationList: ArrayList<CollectionControlsList> = ArrayList()

    var tool: EasyDynamicForm = EasyDynamicForm(list,context,recyclerView,validationList)

    fun  start(recyclerView: RecyclerView){

        this.list.forEachIndexed { index, it ->

            if (it.validation && it.type != ListDynamic.typeRow.ROW_TITLE) {

                val obj = CollectionControlsList()

                obj.post = index

                this.validationList.add(obj)

            }
        }

        this.tool = EasyDynamicForm(list,context,recyclerView,validationList)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = GridLayoutManager(context, 1)

        recyclerView.adapter = tool

        BuilderForms.list = ArrayList()

    }
    fun getEasyWrapper(): EasyFormWrapper{

        return easyWrapper
    }

}

fun RecyclerView.start(): DynamicListAdapter {

    val mAdapter: DynamicListAdapter
    val list = BuilderForms.list
    val context = this.context
    val validationList: ArrayList<CollectionControlsList> = ArrayList()

    list.forEachIndexed { index, it ->

        if (it.validation && it.type != ListDynamic.typeRow.ROW_TITLE) {

            val obj = CollectionControlsList()

            obj.post = index

            validationList.add(obj)
        }
    }

    mAdapter = EasyDynamicForm(list, context,this,validationList)

    this.setHasFixedSize(true)
    this.layoutManager = LinearLayoutManager(context)
    this.layoutManager = GridLayoutManager(context, 1)

    this.adapter = mAdapter

    BuilderForms.list = ArrayList()

    return mAdapter

}