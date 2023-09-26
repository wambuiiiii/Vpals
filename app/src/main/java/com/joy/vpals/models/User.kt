package com.joy.vpals.models

import androidx.compose.ui.text.input.TextFieldValue

class User{
    var email:String=""
    var pass:String
    var userid:String=""
//    var description:String=""

    constructor(email: String, pass: String, userid: String){
        this.email=email
        this.pass=pass

        this.userid=userid
//        this.description=description

    }
}