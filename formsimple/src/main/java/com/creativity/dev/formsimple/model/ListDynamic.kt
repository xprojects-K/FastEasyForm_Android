package com.creativity.dev.formsimple.model

import android.graphics.Color.GREEN
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import com.creativity.dev.formsimple.BuilderForms
import com.creativity.dev.formsimple.ui.CalendarActivity
import com.creativity.dev.formsimple.ui.Calendar_H_Activity
import com.creativity.dev.formsimple.model.Utils.Alignment
import com.creativity.dev.formsimple.model.Utils.Animations
import com.creativity.dev.formsimple.model.Utils.Colors
import com.creativity.dev.formsimple.model.Utils.EditText
import com.creativity.dev.formsimple.model.Utils.Images
import com.creativity.dev.formsimple.model.Utils.Lists
import com.creativity.dev.formsimple.model.Utils.Margin
import com.creativity.dev.formsimple.model.Utils.Padding
import com.creativity.dev.formsimple.model.Utils.Setting
import com.creativity.dev.formsimple.model.Utils.Size
import com.creativity.dev.formsimple.model.Utils.Text
import com.creativity.dev.formsimple.model.Utils.Visibility
import com.creativity.dev.formsimple.types.*
import com.creativity.dev.formsimple.ui.SelectActivity
import com.creativity.dev.formsimple.utils.TimerHelper
import java.io.Serializable
import java.util.ArrayList

class ListDynamic:Serializable{

    var tag: String = ""

    //<Text>
    var setText: Text = Text()
    //</>

    //<Lists>
    var setList: Lists = Lists()
    //</>

    var setEditText: EditText = EditText()

    lateinit var action : () -> Unit
    //<Booleans>
    var checked: Boolean = false
    var activeLetter: Boolean = false
    var isAvailable: Boolean = true
    var isSingleList: Boolean = true
    var validation: Boolean = false
    //</>

    //<Types>
    var type: TypeRow = TypeRow.ROW_BASIC
    //</>

    //<Setting config>

    var setting: Setting = Setting()

    //</>

    //<Asset Activity>
    var activity: Class<*> = javaClass
    var bundleActivity: Bundle = Bundle()
    //</>

    //<Animation>
    var setAnimation: Animations = Animations()
    //</>

    //<Color Text>
    var setColor: Colors = Colors()
    //</>

    var setDateFormat: String = TimerHelper.longDate

    //<Size Text>
    var setSize: Size = Size()
    //</>

    //<Rules for Global Context>

    var setPadding: Padding = Padding()

    var setMargin: Margin = Margin()


    //</>

    //<InputType Edit Text Max Length control>
    var maxLength: Int = 99
    //</>

    //<Alignment Text>
    var setAlignment: Alignment = Alignment()
    //</>

    //<InputType Edit Text>
    var inputTypeEditText: Int = InputType.TYPE_CLASS_TEXT //<-- This is general, but you can add any Type Text For your Edit Text
    //</>

    //<InputVisible Type>

    var setVisibility: Visibility = Visibility()

    //</>

    //<Gravity Type>
    var gravityTitle: Int = Gravity.LEFT
    var universalContentGravity: Int = Gravity.CENTER
    //</>

    //<Endable>
    var isEndableImageSelected: Boolean = true
    //</>

    //<Img Content>
    var setImage: Images = Images()
    //</>

    constructor(type: Int){

        when (type) {

             ROW_CHECK -> {

                 this.setText.icon = "check"
                 this.isAvailable = false
                 this.setEditText.isEditable = false
                 this.setSize.title = 14.0f

                 //this.setVisibility.title = View.GONE
                 this.setVisibility.description = View.VISIBLE
                 this.setVisibility.check = View.VISIBLE
                 this.setVisibility.imgContentEnable = View.VISIBLE
                 this.setVisibility.imgContentEnable2 = View.GONE
                 this.type = TypeRow.ROW_CHECK
                 this.setAlignment.description = View.TEXT_ALIGNMENT_TEXT_START
            }


              ROW_SINGLE_CHECK_LIST ->{

                  this.isSingleList = true
                  this.setEditText.isEditable = false
                  this.setVisibility.check = View.VISIBLE
                  this.setVisibility.description = View.VISIBLE
                  //this.imageContentEnable = View.VISIBLE
                  //this.imageContentEnable2 = View.GONE
                  this.setImage.selected = this.setImage.arrow
                  this.setAlignment.description = View.TEXT_ALIGNMENT_TEXT_END
                  this.isEndableImageSelected = false
                  this.activity = SelectActivity::class.java
                  this.type = TypeRow.ROW_SINGLE_CHECK_LIST

              }

              ROW_MULTIPLE_CHECK_LIST ->{

                  this.isSingleList = false
                  this.setEditText.isEditable = false
                  this.setVisibility.check = View.VISIBLE
                  this.setVisibility.description = View.VISIBLE
                  this.setImage.selected = this.setImage.arrow
                  this.setAlignment.description = View.TEXT_ALIGNMENT_TEXT_END
                  this.isEndableImageSelected = false
                  this.activity = SelectActivity::class.java
                  this.type = TypeRow.ROW_MULTIPLE_CHECK_LIST
              }

              ROW_CHECK_TITLE -> {

                this.setText.icon = "check"
                this.isAvailable = false
                  this.setEditText.isEditable = false
                this.setVisibility.description = View.VISIBLE
                this.setVisibility.check = View.VISIBLE
                this.type = TypeRow.ROW_CHECK_TITLE
            }

            ROW_TITLE -> {

                this.setVisibility.title = View.VISIBLE
                this.setVisibility.separator = View.GONE
                this.setVisibility.description = View.GONE
                this.setColor.title = GREEN
                this.setEditText.isEditable = false
                this.universalContentGravity = Gravity.LEFT

               this.setMargin.content.top = 15
               this.setPadding.content.left = 10
               this.setPadding.content.rigth = 10
               this.setPadding.content.top = 10

               this.type = TypeRow.ROW_TITLE

            }

              ROW_CALENDAR_HOUR -> {

                  this.setVisibility.title = View.VISIBLE
                  this.setVisibility.check = View.VISIBLE
                  this.setVisibility.description = View.VISIBLE
                  this.setImage.selected = this.setImage.arrow
                  this.isEndableImageSelected = false
                  this.setEditText.isEditable = false
                  this.activity = CalendarActivity::class.java
                  this.type = TypeRow.ROW_CALENDAR_HOUR

              }

              ROW_CALENDAR -> {

                  this.setVisibility.title = View.VISIBLE
                  this.setVisibility.check = View.VISIBLE
                  this.setVisibility.description = View.VISIBLE
                  this.setImage.selected = this.setImage.arrow
                  this.isEndableImageSelected = false
                  this.setEditText.isEditable = false
                  this.setEditText.isEditable = false
                  this.activity = Calendar_H_Activity::class.java
                  this.type = TypeRow.ROW_CALENDAR_DAY
              }

             ROW_EDIT -> {

                this.type = TypeRow.ROW_EDIT
                this.setVisibility.description = View.GONE
                this.setVisibility.editText = View.VISIBLE
                this.isAvailable = true
                this.setVisibility.description = View.GONE
                this.setVisibility.editText = View.VISIBLE
                this.setVisibility.styleEdit = View.VISIBLE
                this.setVisibility.icon = View.GONE
                this.setVisibility.title = View.GONE

            }

             ROW_ACTIVITY -> {

                this.setVisibility.title = View.VISIBLE
                this.setVisibility.check = View.VISIBLE
                this.setImage.selected = this.setImage.arrow
                this.isEndableImageSelected = false
                this.type = TypeRow.ROW_ACTIVITY
            }


            ROW_ON_CLICK -> {

                this.type = TypeRow.ROW_ON_CLICK
            }


            ROW_COMMENT -> {

                this.setVisibility.icon = View.VISIBLE
                this.setVisibility.title = View.VISIBLE
                this.setVisibility.description = View.VISIBLE
                  this.setEditText.isEditable = false
                this.type = TypeRow.ROW_COMMENT

            }

              ROW_DIALOG_CO ->{

                this.setVisibility.icon = View.VISIBLE
                this.setVisibility.title = View.VISIBLE
                  this.setEditText.isEditable = false
                this.type = TypeRow.ROW_DIALOG_CO
            }

              ROW_INFO ->{
                  this.setEditText.isEditable = false
                  this.setVisibility.description = View.VISIBLE
                  this.type = TypeRow.ROW_INFO
              }


            else -> {
                print("x is neither 1 nor 2")
            }
        }

    }

    enum class TypeRow {
        ROW_BASIC,
        ROW_TITLE,
        ROW_DESCRIPTION,
        ROW_ACTIVITY,
        ROW_CHECK,
        ROW_COMMENT,
        ROW_DIALOG_CO,
        ONLY_CHECK,
        CHECK_AND_CUESTION,
        ROW_EDIT,
        ROW_CHECK_TITLE,
        ROW_SINGLE_CHECK_LIST,
        ROW_MULTIPLE_CHECK_LIST,
        ROW_INFO,
        ROW_CALENDAR_HOUR,
        ROW_CALENDAR_DAY,
        ROW_ON_CLICK
    }

    fun checkList(obj: () -> Unit) {

        obj()

        this.setList.options =  BuilderForms.options

        BuilderForms.options = ArrayList()

        this.setList.options.forEachIndexed { _, option ->

            if(option.check){

                setText.text = option.text

                return@forEachIndexed
            }

        }

    }

    fun onClick(obj: () -> Unit) {

        this.action = obj

    }

}