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
import com.creativity.dev.formsimple.types.ROW_CALENDAR
import com.creativity.dev.formsimple.types.ROW_CHECK
import com.creativity.dev.formsimple.types.ROW_EDIT
import com.creativity.dev.formsimple.types.ROW_INFO
import com.creativity.dev.formsimple.types.ROW_SINGLE_CHECK_LIST
import com.creativity.dev.formsimple.types.ROW_TITLE
import com.example.dreamteach.listselectdinamic.IGBDynamicList.EasyForm

const val tagSex:String = "c098975e-f6ce-4e44-bdc7-b11ecdb0d234"
const val tagFoodList:String = "2403020e-82dc-4e31-8008-67263069ec1e"
const val tagEditAge:String = "35c090b2-cf81-43c9-8912-d438e47dc80e"
const val tagCheck:String = "494a468f-286e-492b-897f-e238c37fd8f3"

class MainActivity : AppCompatActivity(), FormsListenerIGB {

    private lateinit var rv_main: RecyclerView // Add RecyclerView into xml

    private lateinit var easyForm: EasyForm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.easyForm = EasyForm(this)

        this.rv_main = findViewById(R.id.rv_main)

        this.init()

    }

    private fun init(){

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

            start(rv_main)
        }

    }



    override fun actionFormResponse(result: ResponseFormsIGB) {

        // Manejar la respuesta del formulario si es necesario
        // Por ejemplo, puedes obtener los resultados aquí
        val frecuenciaVisita = easyForm.tool.getResultByTag("FRECUENCIA_VISITA")

        if(frecuenciaVisita.options.count { select -> select.check } > 0){

            // result.iconArrow = com.creativity.dev.formsimple.R.drawable.success

            result.text = ""
            result.title = ""
          //  easyForm.tool.updateRow("FRECUENCIA_VISITA",result)

        }
        // Puedes procesar los resultados aquí según tus necesidades
    }

}
