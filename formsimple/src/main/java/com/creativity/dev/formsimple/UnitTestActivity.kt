package com.creativity.dev.formsimple

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.types.ROW_CALENDAR
import com.creativity.dev.formsimple.types.ROW_EDIT
import com.creativity.dev.formsimple.types.ROW_ON_CLICK
import com.creativity.dev.formsimple.types.ROW_SINGLE_CHECK_LIST
import com.example.dreamteach.listselectdinamic.IGBDynamicList.EasyForm
import java.lang.Exception

class UnitTestActivity : AppCompatActivity() {

    private lateinit var easyForm: EasyForm

    private lateinit var rv_main: RecyclerView

    val success= "OK"

    val error = "Error"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_test)

        this.easyForm = EasyForm(this)

        this.rv_main = findViewById(R.id.rv_unit_test)

    }

    fun init() : Boolean{

        try {

            easyForm.apply {

                Row(ROW_SINGLE_CHECK_LIST) {
                    tag = "FRECUENCIA_VISITA"
                    setText.title = "¿Con qué frecuencia suele visitar el cine Ya?"
                    setSize.title = 14f
                    checkList {
                        option { text = "Una vez al mes" }
                        option { text = "Un par de veces al año" }
                        option { text = "Solo ocasionalmente" }
                        option { text = "Primera visita" }
                    }
                    setting.rowSingleCheck.activeIconSuccess = true
                    validation = true // Habilitar validación
                }

                // Calidad de las proyecciones
                Row(ROW_SINGLE_CHECK_LIST) {
                    tag = "CALIDAD_PROYECCIONES"
                    setText.title = "En una escala del 1 al 5, ¿cómo calificaría la calidad de las proyecciones en Cine Ya?"
                    setSize.title = 14f
                    checkList {
                        option { text = "1 - Mala calidad" }
                        option { text = "2 - Regular" }
                        option { text = "3 - Aceptable" }
                        option { text = "4 - Buena" }
                        option { text = "5 - Excelente calidad" }
                    }
                    validation = true // Habilitar validación
                }

                // Nombre del cliente
                Row(ROW_EDIT) {
                    setText.title = "Nombre"
                    setText.text = "Test"
                    setText.edtHint = "Ingrese su nombre"
                    tag = "nombreCliente"
                    validation = true
                }

                Row(ROW_CALENDAR) {
                    setText.title = "Date of Birth"
                    tag = "dateOfBirth"
                    validation = true
                }


                // Calificación de la película
                Row(ROW_SINGLE_CHECK_LIST) {
                    setText.title = "Calificación de la película"
                    tag = "calificacionPelicula"

                    checkList {
                        option { text = "Excelente" }
                        option { text = "Buena" }
                        option { text = "Regular" }
                        option { text = "Mala" }
                    }

                    validation = true
                }

                // Comentario
                Row(ROW_EDIT) {
                    setText.title = "Comentario"
                    setText.edtHint = "Ingrese su comentario"
                    tag = "comentario"
                    validation = true
                }

                // Correo electrónico (opcional)
                Row(ROW_EDIT) {
                    setText.title = "Correo Electrónico (Opcional)"
                    setText.edtHint = "Ingrese su correo electrónico"
                    tag = "correoElectronico"
                }

                Row(ROW_ON_CLICK) {
                    setText.title = "Visitar sitio web de Cine Ya"
                    onClick {
                        val url = "https://spc.tropigas.com.pa/system-detect/index.html" // Aquí debes poner el enlace real del sitio web del cine
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    }
                }
                start(rv_main)
            }

           return true

        }catch (ex: Exception){

            print(ex.message)

            return false

        }

    }

    fun validateAll() : String{

        return try {

            val result = easyForm.tool.validateAll()

            if(!result)

                this.success

            else

                this.error



        }catch (ex: Exception){

            this.error

        }

    }

    fun validateByTag() : String{

        return try {

            val isSuccessOne = easyForm.tool.validateByTag("nombreCliente")

            val isSuccessTwo = easyForm.tool.validateByTag("calificacionPelicula")

            if(isSuccessOne && !isSuccessTwo){

                this.success

            }
            else

                this.error



        }catch (ex: Exception){

            this.error

        }

    }

}