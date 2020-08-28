package com.srisuk.carwashcustomer.model

 data class LoginRequest(
     var username:String?=null,
     var password:String?=null,
     var role :Int?=null
 )
