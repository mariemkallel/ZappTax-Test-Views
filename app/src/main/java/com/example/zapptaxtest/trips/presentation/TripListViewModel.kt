package com.example.zapptaxtest.trips.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zapptaxtest.trips.presentation.model.CurrentTripModel
import com.example.zapptaxtest.trips.presentation.model.PreviousTripModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class TripListViewModel : ViewModel() {
    val currentTripList = MutableLiveData<MutableList<CurrentTripModel>>(mutableListOf())
    val previousTripList = MutableLiveData<MutableList<PreviousTripModel>>(mutableListOf())

    init {
        val defaultCurrentTrip = CurrentTripModel("Belgique", "Le 1 Jan 2023", 1000.0, 200.0)
        currentTripList.value?.add(defaultCurrentTrip)
        currentTripList.value = currentTripList.value

        val defaultPreviousTrip = PreviousTripModel("Espagne", "Le 1 Feb 2022", 1500.0, 300.0)
        previousTripList.value?.add(defaultPreviousTrip)
        previousTripList.value = previousTripList.value
    }
    fun addNewTrip() {
        val newTrip = generateRandomTrip()
        currentTripList.value?.add(newTrip)
        currentTripList.value = currentTripList.value
    }

    private fun generateRandomTrip(): CurrentTripModel {
        val countries = listOf("Belgique", "Espagne", "France")
        val randomCountry = countries.random()
        val currentDate = getCurrentFormattedDate()
        val randomTotalSpent = String.format("%.2f", Random.nextDouble(0.0, 3000.0)).toDouble()
        val refundValue = String.format("%.2f", randomTotalSpent * 0.2).toDouble()
        return CurrentTripModel(randomCountry, currentDate, randomTotalSpent, refundValue)
    }

    private fun getCurrentFormattedDate(): String {
        val calendar = Calendar.getInstance()
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = SimpleDateFormat("MMM", Locale.FRENCH).format(calendar.time)
        val year = calendar.get(Calendar.YEAR)
        return "Le $dayOfMonth $month $year"
    }
}
