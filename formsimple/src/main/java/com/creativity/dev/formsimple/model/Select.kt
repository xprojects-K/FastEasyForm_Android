package com.creativity.dev.formsimple.model

import com.creativity.dev.formsimple.R
import java.io.Serializable


class Select : Serializable{

    var tag: String   = ""
    var text: String = ""
    var check: Boolean = false
    var setImage: ImageCheck = ImageCheck()

    constructor(tag: String, text: String, check: Boolean) {

        this.tag = tag

        this.text = text

        this.check = check

    }

    constructor(text: String, check: Boolean,icon: Int) {

        this.text = text

        this.check = check

        this.setImage.icon = icon

    }

    constructor(text: String, icon: Int) {

        this.text = text

        this.setImage.icon = icon

    }

    constructor(text: String, check: Boolean) {

        this.text = text

        this.check = check

    }

    constructor(text: String) {

        this.text = text

        this.check = false

        this.tag = ""

    }

    constructor()
}

class ImageCheck: Serializable{

    var selected: Int = R.drawable.check_2

    var didSelected: Int = R.drawable.stop

    var icon: Int = 0

    var size:SizeB = SizeB()

}

class SizeB: Serializable{

    var iconHeight: Int = 100

    var iconWidth: Int = 100

}