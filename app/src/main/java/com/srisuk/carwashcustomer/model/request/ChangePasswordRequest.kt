package com.srisuk.carwashcustomer.model.request

data class ChangePasswordRequest(
    var OldPassword: String? = null,
    var NewPassword: String? = null,

)
