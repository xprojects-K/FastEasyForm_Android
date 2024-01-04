package com.creativity.dev.formsimple.adapter.options

import android.content.Context
import android.content.res.AssetManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.R

import com.creativity.dev.formsimple.extensions.eventImageCheckBoxSelect
import com.creativity.dev.formsimple.interfaces.EventList
import com.creativity.dev.formsimple.interfaces.EventListDynamic
import com.creativity.dev.formsimple.model.Select

class SelectAdapter (): RecyclerView.Adapter<SelectAdapter.MyViewHolder>() {

    lateinit var list: List<Select>

    lateinit var asset: AssetManager

    lateinit var mContext: Context

    private var imagePositive: Int = R.drawable.check_2

    private var imageNegative: Int = R.drawable.stop

    private var imageCheck: Int = R.drawable.stop

    private var isSingleSelection: Boolean = false

   // private lateinit  var view: View

    override fun getItemCount(): Int {
      return list.size //To change body of created functions use File | Settings | File Templates.
    }

    constructor(listMenu: List<Select>, asset: AssetManager, mContext: Context, isSingleSelection:Boolean) : this() {
        this.list = listMenu
        this.asset = asset
        this.mContext = mContext
        this.isSingleSelection = isSingleSelection
    }

    fun getListReady(): List<Select>{
        return  list;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_select, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val generalList = list[position]
        val check: Boolean = generalList.check
        val icon: Int = generalList.setImage.customIconResId

        holder.title.text = generalList.text

        holder.contentImg.setImageDrawable(null)
        holder.contentImg.setImageResource(0)

        holder.icon.layoutParams.height = generalList.setImage.size.iconHeight;

        holder.icon.layoutParams.width = generalList.setImage.size.iconWidth;

        if(check)
            holder.contentImg.setBackgroundResource(generalList.setImage.selectedIconResId)
        else
            holder.contentImg.setBackgroundResource(generalList.setImage.didSelectedIconResId)

        if(icon > 0)
            holder.icon.setBackgroundResource(icon)
        else
            holder.icon.visibility = View.GONE

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, EventListDynamic {

        var title: TextView
        var UnvContent: LinearLayout
        var contentImg: ImageView
        var icon: ImageView

        init {

            title = view.findViewById(R.id.tv_title)
            UnvContent = view.findViewById(R.id.lny_content)
            contentImg = view.findViewById(R.id.img_check)
            icon = view.findViewById(R.id.icon)

            UnvContent.setOnClickListener(this)
            UnvContent.eventImageCheckBoxSelect(this,contentImg)

        }

        override fun onClick(v: View) {

        }


        override fun eventEdtiText(str: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun eventChecked(isSelected: Boolean): Int {
            val position: Int = bindingAdapterPosition
            var imageSelected: Int = 0
            val modelList = list[position]

            list[position].check = isSelected

            imageSelected = if(isSelected)
                modelList.setImage.selectedIconResId
            else
                modelList.setImage.didSelectedIconResId

            imageCheck = imageSelected

            if(isSingleSelection && mContext is EventList){

                val event: EventList = mContext as EventList

                list.forEach { it.check = false }

                list[position].check = isSelected

                event.eventSetList(list)
            }


            return imageSelected
        }

        override fun getSelected(): Boolean {

            val position: Int = bindingAdapterPosition
            if(position >= 0)
                return list.get(position).check
            else
                return false
        }
    }

}
