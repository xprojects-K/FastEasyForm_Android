package com.creativity.dev.formsimple.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.creativity.dev.formsimple.R
import com.creativity.dev.formsimple.databinding.ActivityCalendarHBinding
import com.creativity.dev.formsimple.model.ColectionCalendar
import com.creativity.dev.formsimple.model.ListObject
import com.creativity.dev.formsimple.utils.GeneralHelper
import com.creativity.dev.formsimple.utils.TimerHelper
import java.text.SimpleDateFormat
import java.util.*

class Calendar_H_Activity : AppCompatActivity() {

    val context = this
    var getDateString: String = ""
    var getZoneId: String = ""
    var title: String = ""
    var formatDate: String = TimerHelper.longDate
    var listCalendarDay: List<Date> = ArrayList()
    lateinit var objCollectionCalendar: ColectionCalendar
    private var colorTitleToolbar: Int = Color.WHITE
    private var colorBackgroundToolbar: Int = Color.rgb(101,185,102)
    private val timerHelper = TimerHelper()
    private lateinit var binding: ActivityCalendarHBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarHBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundleData()
        activityCreateToolbar()
        setRangeDate(listCalendarDay)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.save_search, menu)

        return true
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.checked) {

            ListObject.eventList.evenSetSimpleString(binding.tvDate1.text.toString())

            finish()

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    // title: getPutExtra
    // description: recoge los datos enviados desde la actividad que hace llamada.
    // Programmer: jGutierrez.

    private fun getBundleData() {

        val extras = intent.getBundleExtra(GeneralHelper.keyBundle())

        if (extras != null) {

            val array = extras.getSerializable(LIST_IGB_CA) as ArrayList<ColectionCalendar>

            objCollectionCalendar = array[0]

            title = objCollectionCalendar.title
            colorBackgroundToolbar = objCollectionCalendar.colorToolbar
            colorTitleToolbar = objCollectionCalendar.colorTitleToolbar
            listCalendarDay = objCollectionCalendar.listDate
            getDateString = objCollectionCalendar.text
            formatDate = objCollectionCalendar.format

            if(getDateString.isNotEmpty()){
                val selectedDate: Date = GeneralHelper.parseDate(getDateString,formatDate)
                binding.cvDate.setDate(selectedDate.time)
            }

              if(objCollectionCalendar.background > 0)
                 binding.contentD.setBackgroundResource(objCollectionCalendar.background)

        }
    }

    private fun setRangeDate(listDate:List<Date>){

        if(listDate.size > 1){

            binding.cvDate.maxDate =  GeneralHelper.toCalendar(listDate.last()).timeInMillis

            binding.cvDate.minDate = GeneralHelper.toCalendar(listDate.first()).timeInMillis

            if(getDateString.isNotEmpty()) {

                val selectedDate: Date = GeneralHelper.parseDate(getDateString,formatDate)

                binding.cvDate.date = selectedDate.time

                binding.tvDate1.text = timerHelper.setTextCalendar(selectedDate,formatDate)

            }
        }

        binding.cvDate.setOnDateChangeListener(object : CalendarView.OnDateChangeListener {

            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {

                val calendar = GregorianCalendar(year, month, dayOfMonth)

                val date = calendar.time

                binding.tvDate1.text = timerHelper.setTextCalendar(date,formatDate)

            }
        })
    }

    private fun setStringDate(date: Date){
        val ss = SimpleDateFormat("yyyy-MM-dd")
        val currentdate = ss.format(date)

    }

    // title: createToolbar
    // description: generar un menu personalizado con botones a la derecha para el toolbar.
    // programmer: jGutierrez
    private fun activityCreateToolbar() {

        val mToolbar =  binding.toolbar

        mToolbar?.title = title
        setSupportActionBar(mToolbar)
        mToolbar?.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        mToolbar?.inflateMenu(R.menu.save_search)
        mToolbar?.setTitleTextColor(colorTitleToolbar)
        mToolbar?.setBackgroundColor(colorBackgroundToolbar)
        mToolbar?.setNavigationOnClickListener(View.OnClickListener { finish() })
    }
}
