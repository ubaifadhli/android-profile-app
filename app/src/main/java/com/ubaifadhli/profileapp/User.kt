package com.ubaifadhli.profileapp

import java.io.Serializable

class User(username : String, password : String, nrp : String) : Serializable {
    var username : String = username
    var password : String = password
    var nrp : String = nrp
}