package com.creativity.dev.formsimple.ui

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.adapter.options.SelectAdapter
import com.creativity.dev.formsimple.databinding.ActivitySelectBinding
import com.creativity.dev.formsimple.interfaces.EventList
import com.creativity.dev.formsimple.model.ListObject
import com.creativity.dev.formsimple.utils.GeneralHelper
import java.util.ArrayList


const val LIST_IGB: String = "d467baa9-f1e3-4e43-862f-8c44c10fac4b"
const val INTERNAL_KEY: String = "48537394-a346-4a0f-b915-13c1009f427a"

class SelectActivity : AppCompatActivity(), EventList {

    private var title: String = "Text"

    private var emptyMessages: String = ""

    private var isSingleCheck: Boolean = false

    private lateinit  var listObject : ListObject

    private var mContext = this

    private var mAdapter: SelectAdapter? = null

    private var colorTitleToolbar: Int = Color.WHITE

    private var colorBackgroundToolbar: Int = Color.rgb(101,185,102)

    private lateinit var binding: ActivitySelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getPutExtraIntent()

        activityCreateToolbar()

        view()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.save_search, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.checked && listObject.list.isNotEmpty()) {

            ListObject.eventList.eventSetList(mAdapter!!.getListReady())
            finish()

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun eventSetList(inputList: List<Any>) {
        ListObject.eventList.eventSetList(mAdapter!!.getListReady())
        finish()
    }

    private fun getPutExtraIntent() {

        val extras = intent.getBundleExtra(INTERNAL_KEY)
        var arrayListObj: ArrayList<ListObject>  = ArrayList()

        if (extras != null) {

            arrayListObj = extras.getSerializable(LIST_IGB) as ArrayList<ListObject>
            listObject = arrayListObj[0]

            title = listObject.title
            isSingleCheck = listObject.isSingle
            colorBackgroundToolbar = listObject.colorToolbar
            colorTitleToolbar = listObject.colorTitleToolbar
            emptyMessages = this.getString(R.string.Empty_messages)

            if(listObject.backgroundContent > 0)
                binding.contentList.setBackgroundResource(listObject.backgroundContent)
        }
    }

    private fun view(){

        if(listObject.list.isNotEmpty()){

            mAdapter = SelectAdapter(listObject.list, mContext.assets, mContext,isSingleCheck)

            binding.rvSelected.setHasFixedSize(true)
            binding.rvSelected.layoutManager = LinearLayoutManager(mContext)
            binding.rvSelected.layoutManager = GridLayoutManager(mContext, 1)

            binding.rvSelected.adapter = mAdapter

        }else {

            GeneralHelper.setContentEmpty(binding, true)

            binding.rvSelected.visibility = View.GONE

            if(listObject.emptyMessage.isNotEmpty())
                binding.include.tvEmpty.text = listObject.emptyMessage

            if(listObject.imageEmpty > 0)
               binding.include.imgEmpty.setImageResource(listObject.imageEmpty)

        }


    }

    override fun evenSetSimpleString(str: String) {

    }

    // Title: createToolbar
    // Description: generar un menu personalizado con botones a la derecha para el toolbar.
    // Programmer: JGutierrez
    private fun activityCreateToolbar() {

        val mToolbar = binding.toolbar2

        if(!isSingleCheck){

            mToolbar.title = title
            setSupportActionBar(mToolbar)
            mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
            mToolbar.inflateMenu(R.menu.save_search)
            mToolbar.setTitleTextColor(colorTitleToolbar)
            mToolbar.setBackgroundColor(colorBackgroundToolbar)
            mToolbar.setNavigationOnClickListener(View.OnClickListener { finish() })

        }else{

            GeneralHelper.createToolbar(this,mToolbar,title,colorTitleToolbar,colorBackgroundToolbar)

        }


    }


}
