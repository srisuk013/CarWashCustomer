package com.srisuk.carwashcustomer.model.request

 data class LoginRequest(
     var username:String?=null,
     var password:String?=null,
     var role :Int=2
 )
