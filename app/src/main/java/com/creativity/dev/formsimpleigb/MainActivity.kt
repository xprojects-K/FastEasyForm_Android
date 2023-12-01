package com.creativity.dev.formsimpleigb

import android.os.Bundle
import android.text.InputType
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.interfaces.FormsListenerIGB
import com.creativity.dev.formsimple.model.Select
import com.creativity.dev.formsimple.Row
import com.creativity.dev.formsimple.model.ResponseFormsIGB
import com.creativity.dev.formsimple.model.SetRow
import com.creativity.dev.formsimple.option
import com.creativity.dev.formsimple.types.*
import com.example.dreamteach.listselectdinamic.IGBDynamicList.EasyForm
import com.example.dreamteach.listselectdinamic.utils.AlertDialogManager

const val tagSex:String = "c098975e-f6ce-4e44-bdc7-b11ecdb0d234"
const val tagFoodList:String = "2403020e-82dc-4e31-8008-67263069ec1e"
const val tagEditAge:String = "35c090b2-cf81-43c9-8912-d438e47dc80e"
const val tagCheck:String = "494a468f-286e-492b-897f-e238c37fd8f3"

class MainActivity : AppCompatActivity(), FormsListenerIGB {

    private lateinit var rv_main: RecyclerView

    private lateinit var easyForm: EasyForm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.easyForm = EasyForm(this)

        this.rv_main = findViewById(R.id.rv_main)

        this.init()

    }

    private fun init(){

    /*
      Construye tu formulario aqui...
     */

    }



    override fun actionFormResponse(result: ResponseFormsIGB) {



    }

}
