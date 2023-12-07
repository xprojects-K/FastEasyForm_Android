package com.creativity.dev.formsimpleigb

import android.os.Bundle
import android.text.InputType
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.Row
import com.creativity.dev.formsimple.interfaces.FormsListenerIGB
import com.creativity.dev.formsimple.model.ResponseFormsIGB
import com.creativity.dev.formsimple.option
import com.creativity.dev.formsimple.types.ROW_ACTIVITY
import com.creativity.dev.formsimple.types.ROW_MULTIPLE_CHECK_LIST
import com.creativity.dev.formsimple.types.ROW_SINGLE_CHECK_LIST
import com.creativity.dev.formsimple.types.ROW_TITLE
import com.example.dreamteach.listselectdinamic.IGBDynamicList.EasyForm

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

        Row(ROW_TITLE) { // <--- Add Title

            setText.title = "Encuesta" //<--- add your title name

            setColor.title = R.color.colorBlack
        }

        Row(ROW_ACTIVITY) { // <--- Add Title

            setText.title = "Compose Activity" //<--- add your title name

            activity = ComposeActivity::class.java

        }

        Row(ROW_TITLE) { // <--- Add Title

            setText.title = "Encuesta" //<--- add your title name

            setColor.title = R.color.colorBlack

        }

        Row(ROW_MULTIPLE_CHECK_LIST){

            setText.tag = tagSex
            setText.title = "Tipo de pelicula"
            setColor.backgroundToolbar = R.color.colorBlack

            checkList{

                option(){
                    text = "Acción"
                    setImage.selectedIconResId = R.drawable.jdjs
                    setImage.didSelectedIconResId = R.drawable.empty_box
                }

                option(){
                    text = "Drama"
                }

                option(){
                    text = "Comedia"
                }

                option(){
                    text = "Fantasia"

                }

            }

            validation = true

        }


        easyForm.start(rv_main)
    }



    override fun actionFormResponse(result: ResponseFormsIGB) {



    }

}
