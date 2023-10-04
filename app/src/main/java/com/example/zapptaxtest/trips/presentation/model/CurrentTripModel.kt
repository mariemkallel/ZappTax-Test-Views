package com.example.zapptaxtest.trips.presentation.model

data class CurrentTripModel(
    val country: String,
    val date: String,
    val totalSpent: Double,
    val refundValue: Double,
)