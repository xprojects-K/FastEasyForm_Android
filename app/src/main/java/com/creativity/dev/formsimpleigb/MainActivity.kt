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

    private var mContext = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.easyForm = EasyForm(this)

        this.rv_main = findViewById(R.id.rv_main)

        this.init()

    }

    private fun init(){

        Row(ROW_TITLE){

            setText.title = "Favorite books"
            setColor.title = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)

        }

        Row(ROW_ON_CLICK){

            setText.title = "Open Navegator"

            onClick{

                AlertDialogManager.simpleAlerts(mContext,"Alert", "hey is work beby")

            }

        }

        Row(ROW_ACTIVITY){ // <-- Here Call Any activity
            setText.title = "Action Activity #1"//<-- title .
            activity = ComposeActivity::class.java // <-- Add your activity
        }

        Row(ROW_ACTIVITY){

            setText.title = "Action Activity #2"// title row.
            activity = ExampleActivity::class.java // <-- Add your activity

        }

        Row(ROW_TITLE){

            setText.title = "Food List"
            validation = true
            setColor.title = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)

        }

        Row(ROW_MULTIPLE_CHECK_LIST){

            setText.title = "Menú" // Add title

            checkList{

                for (i in 1..10) {

                    option(){
                        text = "$i) Opción"
                    }

                }

            }

            validation = true
            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext, R.color.colorPrimary) // // Add color in the toolbar (OPTIONAL but RECOMENDABLE)

        }

        Row(ROW_MULTIPLE_CHECK_LIST){

            setText.tag = tagFoodList // <---  tag for identification of the row
            setText.title = "Fruits"   // <---  Your title
            // Personalize your message empty
            setText.emptyMessages = "Please select your favorite fruits." // Your message for empty list (OPTIONAL)
            setColor.imageEmpty = R.drawable.empty_example   // Add an image for empty list (OPTIONAL)
            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext, R.color.colorPrimary) // Add color in the toolbar (OPTIONAL but RECOMENDABLE)

            checkList{

                option(){
                    text = "Apple"
                    setImage.icon = R.drawable.nin
                }

                option(){
                    text = "Banana"
                    setImage.icon = R.drawable.nin
                }

                option(){
                    text = "Watermelon"
                    setImage.icon = R.drawable.nin
                }

            }

        }

        Row(ROW_TITLE){

            setText.title = "Questions"
            setColor.title = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)

        }

        Row(ROW_CHECK){

            setText.text= "Do you like job?" // Add text for the text
            setText.tag = tagCheck //tag for identification of the row
            checked = false // Initialize check in false or true

        }

        Row(ROW_CHECK){

            setText.text= "Do you like this librery?" // Add text fot he text
            checked = false // Initialize check in false or true

        }

        Row(ROW_CHECK){

            setText.text= "Is really easy?" // Add text fot he text
            checked = true  // Initialize check in false or true

        }

        Row(ROW_TITLE){
            setText.title = "Information User"
            setColor.title = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)
        }

        Row(ROW_EDIT){

            setText.title = "Correo Electronico"// title row.
            setText.text= "jose19.26@hotmail.com"// short description.
            inputTypeEditText = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS //  To choose type EDITTEXT (https://developer.android.com/reference/android/widget/EditText)

        }

        Row(ROW_EDIT){
            setText.title = "Firts Name" // Add only text, but the text edit type is default
        }

        Row(ROW_EDIT){

            setText.title = "Lastname" // Add only text, but the text edit type is default
            setText.emptyMessages = "Please insert lastname"
            validation = true  // Add it is you want validate this row

        }

        Row(ROW_EDIT){

            setText.title = "Phone"// title row.
            inputTypeEditText = InputType.TYPE_CLASS_PHONE //  To choose type EDITTEXT (https://developer.android.com/reference/android/widget/EditText)
        }

        Row(ROW_EDIT){

            setText.tag =  tagEditAge
            setText.title = "Age"
            maxLength = 2
            inputTypeEditText = InputType.TYPE_CLASS_NUMBER
            setText.emptyMessages = "Please insert your ages"
            validation = true

        }

        Row(ROW_SINGLE_CHECK_LIST){

            setText.tag = tagSex
            setText.title = "Sex"

            checkList{

                option(){
                    text = "Male"
                    setImage.icon = R.drawable.nin
                }

                option(){
                    text = "Famele"
                    setImage.icon = R.drawable.nin
                }

            }

            validation = true

            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext,R.color.colorPrimary)

        }

        Row(ROW_SINGLE_CHECK_LIST){

            checkList{

                option(){
                    text = "Panamá"
                    check = false
                    setImage.icon = R.drawable.nin
                }

                option(){
                    text = "Peru"
                    check = true
                    setImage.icon = R.drawable.nin
                }

            }

            setText.title = "What is your favorite country?"

            setColor.backgroundContent = R.drawable.jdjs
            validation = true
            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext, R.color.colorPrimary)

        }

        Row(ROW_CALENDAR_HOUR){

            setText.title = "Hour Begin"
            setText.tag = "001"
            validation = true
            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext, R.color.colorPrimary)

        }

        Row(ROW_CALENDAR){

            setText.title = "Cumpleaños"
            setText.tag = "001"
            validation = true
            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
            setColor.backgroundContent = R.drawable.jdt

        }

        Row(ROW_CALENDAR_HOUR){

            setText.title = "Hour End"
            validation = true
            setColor.backgroundToolbar = ContextCompat.getColor(applicationContext,  R.color.colorPrimary)
            setColor.backgroundContent = R.drawable.jdjs

        }

        Row(ROW_TITLE){

            setText.title = "Information App"
            setAlignment.text = View.TEXT_ALIGNMENT_TEXT_END
            setColor.title = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)

        }

        Row(ROW_INFO){

            setText.title = "Versión"// title row.
            validation = true
            setText.text = "v2.0.0"

        }

        Row(ROW_INFO){

            setText.title = "Date"// title row.
            validation = true
            setText.text= "Released December 26, 2018"

        }

        Row(ROW_INFO){

            setText.title = "Licence"// title row.

            setText.text= "Copyright 2023 José .I Gutièrrez B."

        }


        //Here initialize your recycler view
        easyForm.start(rv_main)

    }

    fun clickEvent(view: View){

        val validate = easyForm.tool.validateAll()  // Validate rows, here validate only one rows where added attribute VALIDATION

        if(validate){ // validate rows

            val str = easyForm.tool.getResultByTag(tagSex).text // Getting text , using tags identifications

           AlertDialogManager.simpleAlerts(this,"Options selected",str)

        }
    }

    override fun actionFormResponse(result: ResponseFormsIGB) {

        if(result.tag == tagSex && result.text.isNotEmpty()){

            AlertDialogManager.simpleAlerts(this,"Alert",result.text)

            easyForm.tool.updateRow(tagCheck, SetRow {checked = true})

        }

    }

}
