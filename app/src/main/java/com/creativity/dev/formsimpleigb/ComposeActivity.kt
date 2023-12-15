package com.creativity.dev.formsimpleigb

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.creativity.dev.formsimple.Row
import com.creativity.dev.formsimple.compose.EasyFormCompose
import com.creativity.dev.formsimple.compose.EasyFormWrapper

import com.creativity.dev.formsimple.model.Select
import com.creativity.dev.formsimple.option
import com.creativity.dev.formsimple.types.ROW_ACTIVITY
import com.creativity.dev.formsimple.types.ROW_CALENDAR
import com.creativity.dev.formsimple.types.ROW_CALENDAR_HOUR
import com.creativity.dev.formsimple.types.ROW_CHECK
import com.creativity.dev.formsimple.types.ROW_EDIT
import com.creativity.dev.formsimple.types.ROW_INFO
import com.creativity.dev.formsimple.types.ROW_MULTIPLE_CHECK_LIST
import com.creativity.dev.formsimple.types.ROW_SINGLE_CHECK_LIST
import com.creativity.dev.formsimple.types.ROW_TITLE
import com.creativity.dev.formsimpleigb.ui.theme.FormSimpleIGBTheme
import com.example.dreamteach.listselectdinamic.IGBDynamicList.EasyForm


class ComposeActivity : ComponentActivity() {

    private val context = this

    private lateinit var easyForm: EasyForm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.easyForm = EasyForm(this)

        setContent {
            FormSimpleIGBTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ComposeScreen(context,easyForm)

                }
            }
        }
    }

}

@Composable
fun ComposeScreen(context:Context,customForm: EasyForm) {

    EasyFormCompose(
        customForm = customForm,
        modifier = Modifier.fillMaxWidth(),
        rows = {

            Row(ROW_TITLE) { // <--- Add Title

                setText.title = "Easy Form" //<--- add your title name
                setColor.title = ContextCompat.getColor(
                    context,
                    R.color.colorPrimaryDark
                ) // <--- Add any colors for title

            }

            Row(ROW_CALENDAR) {
                setText.title = "Date of Birth"
                tag = "dateOfBirth"
                validation = true
            }

            Row(ROW_EDIT) {

                setText.title = "Email"// title row.
                inputTypeEditText = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS //  To choose type EDITTEXT (https://developer.android.com/reference/android/widget/EditText)

            }

            Row(ROW_EDIT) {
                setText.title = "Full name" // Add only text, but the text edit type is default
            }

            Row(ROW_EDIT) {

                setText.title = "Address" // Add only text, but the text edit type is default
                ///  emptyMessages = "Please insert lastname"
                validation = true  // Add it is you want validate this row

            }

            Row(ROW_EDIT){

                setText.title = "Cell Phone"// title row.
                inputTypeEditText = InputType.TYPE_CLASS_PHONE //  To choose type EDITTEXT (https://developer.android.com/reference/android/widget/EditText)
            }

            Row(ROW_CHECK){

                setText.text= "Do you like job?" // Add text for the text
                tag = tagCheck //tag for identification of the row
                checked = true // Initialize check in false or true

            }

            Row(ROW_INFO){
                setText.title = "Licence"// title row.
                setText.text= "Copyright 2018 José I. Gutiérrez B."
            }

        }
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormSimpleIGBTheme {

        val context = LocalContext.current
        val easyForm: EasyForm = EasyForm(context)

        ComposeScreen(context,easyForm)

    }
}