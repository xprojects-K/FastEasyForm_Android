package com.creativity.dev.formsimple.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.databinding.ActivitySelectBinding
import java.text.SimpleDateFormat
import java.util.*

class GeneralHelper{

    companion object {

        fun countLines(str: String): Int {

                val lines = str.split("\r\n|\r|\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                return lines.size

        }

        fun createToolbar (context: Activity,mToolbar: androidx.appcompat.widget.Toolbar,nameActivity: String,colorTitle: Int,colorBackground: Int){

            mToolbar.title = nameActivity

            mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)

            mToolbar.setTitleTextColor(colorTitle)

            mToolbar.setBackgroundColor(colorBackground)

            mToolbar.setNavigationOnClickListener { context.finish() }

        }

        fun createSimpleToolbar (context: Activity, nameActivity: String,colorTitle: Int,colorBackground: Int){
            val mToolbar = context.findViewById<View>(R.id.toolbar_2) as Toolbar
            mToolbar.setTitleTextColor(colorTitle)
            mToolbar.setBackgroundColor(colorBackground)
            mToolbar.title = nameActivity
        }

        fun keyBundle (): String{
            return "KeyBundle"
        }

        fun toCalendar(date: Date): Calendar {
            val cal = Calendar.getInstance()
            cal.time = date
            return cal
        }

        fun setContentEmpty(mActivity: ActivitySelectBinding, isVisible: Boolean){

            val contentEmpty = mActivity.include.contentEmpty

            if(isVisible)
                contentEmpty.visibility = View.VISIBLE
            else
                contentEmpty.visibility = View.GONE

        }

        @SuppressLint("SimpleDateFormat")
        fun parseDate(srt: String,format: String): Date{
            //dd/MM/yyyy
            var date = Date()
            val df = SimpleDateFormat(format)

            return try{

                date = df.parse(srt) as Date
                date

            }catch (e: Exception){
                date
            }

        }
    }
}