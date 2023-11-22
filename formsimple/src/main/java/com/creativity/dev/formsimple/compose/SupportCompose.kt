package com.creativity.dev.formsimple.compose

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.creativity.dev.formsimple.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.recyclerview.widget.RecyclerView
import com.creativity.dev.formsimple.ext.FormSimpleIGB
import com.example.dreamteach.listselectdinamic.IGBDynamicList.EasyForm
import com.example.dreamteach.listselectdinamic.IGBDynamicList.start


open class EasyFormCompose(context: Context) {

    private val rootView: View = LayoutInflater.from(context).inflate(R.layout.custom_layout_rv, null)

    // Add functions or variables as needed
    fun rv():RecyclerView {

      return rootView.findViewById<RecyclerView>(R.id.rv_main_1)

    }

    fun view():View {

        return rootView

    }

}


class EasyFormWrapper(context: Context) : EasyFormCompose(context) {
    // Add your own functions or variables here

    // You can also override or extend existing functions if needed
}

@Composable
fun EasyFormCompose(
    customForm: EasyForm = EasyForm(LocalContext.current),
    modifier: Modifier = Modifier,
    rows: () -> Unit
) {

    rows()

    Box( modifier = Modifier.fillMaxWidth()) // Background color to see the width)
    {
        // Use your custom functions

        customForm.start(customForm.getEasyWrapper().rv())

        // Embed the custom XML layout in the Compose UI

        AndroidView(
            modifier = modifier,
            factory = {  customForm.getEasyWrapper().view() }
        )
    }
}

/*
open class EasyFormCompose(context: Context) {

    private val rootView: View = LayoutInflater.from(context).inflate(R.layout.custom_layout_rv, null)

    private val rv = FormSimpleIGB(context)

    init {

        this.insertLayout(context)

    }
    // Add functions or variables as needed
    fun rv():RecyclerView {

        return rv

    }

    private fun insertLayout(context: Context) {
        // Create a new parent layout (e.g., LinearLayout)
        val parentLayout = LinearLayout(context)
        parentLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        parentLayout.orientation = LinearLayout.VERTICAL

        // Add child views to the parent layout
        parentLayout.addView(this.rv)

        // Set the parent layout as the content view of the activity
        (context as? AppCompatActivity)?.apply {
            setContentView(parentLayout)
        }
    }

    fun view():View {

        return rootView

    }

}
*/


