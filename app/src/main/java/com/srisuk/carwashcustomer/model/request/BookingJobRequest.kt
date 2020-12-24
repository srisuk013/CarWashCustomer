package com.srisuk.carwashcustomer.model.request

data class BookingJobRequest(
    var packageId: Int? = null,
    var carId: Int? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
)
