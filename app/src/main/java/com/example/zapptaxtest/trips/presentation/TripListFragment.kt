package com.example.zapptaxtest.trips.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zapptaxtest.databinding.FragmentTripListBinding
import com.example.zapptaxtest.trips.presentation.adapters.CurrentTripAdapter
import com.example.zapptaxtest.trips.presentation.adapters.PreviousTripAdapter
import com.example.zapptaxtest.trips.presentation.model.CurrentTripModel
import com.example.zapptaxtest.trips.presentation.model.PreviousTripModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class TripListFragment : Fragment() {
    private lateinit var binding: FragmentTripListBinding
    private lateinit var currentTripAdapter: CurrentTripAdapter
    private lateinit var previousTripAdapter: PreviousTripAdapter
    private val currentTripList = mutableListOf<CurrentTripModel>()
    private val previousTripList = mutableListOf<PreviousTripModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Voyages"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentLayoutManager = LinearLayoutManager(requireContext())
        binding.currentListRecyclerView.layoutManager = currentLayoutManager

        val previousLayoutManager = LinearLayoutManager(requireContext())
        binding.previousListRecyclerView.layoutManager = previousLayoutManager

        currentTripAdapter = CurrentTripAdapter(requireContext(), currentTripList)
        previousTripAdapter = PreviousTripAdapter(requireContext(), previousTripList)

        binding.currentListRecyclerView.adapter = currentTripAdapter
        binding.previousListRecyclerView.adapter = previousTripAdapter

        currentTripList.add(generateRandomTrip())
        currentTripAdapter.notifyItemInserted(currentTripList.size - 1)
        previousTripList.add(generateRandomPreviousTrip())
        previousTripAdapter.notifyItemInserted(previousTripList.size - 1)

        binding.addButton.setOnClickListener {
            val newTrip = generateRandomTrip()
            currentTripList.add(newTrip)
            currentTripAdapter.notifyItemInserted(currentTripList.size - 1)
        }
    }
    private fun generateRandomTrip(): CurrentTripModel {
        val countries = listOf("Belgique", "Espagne", "France")
        val randomCountry = countries.random()
        val calendar = Calendar.getInstance()
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = SimpleDateFormat("MMM", Locale.FRENCH).format(calendar.time)
        val year = calendar.get(Calendar.YEAR)
        val currentDate = "Le $dayOfMonth $month $year"
        val randomTotalSpent = String.format("%.2f", Random.nextDouble(0.0, 3000.0)).toDouble()
        val refundValue = String.format("%.2f", randomTotalSpent * 0.2).toDouble()
        return CurrentTripModel(randomCountry, currentDate, randomTotalSpent, refundValue)
    }
    private fun generateRandomPreviousTrip(): PreviousTripModel {
        val countries = listOf("Belgique", "Espagne", "France")
        val randomCountry = countries.random()
        val calendar = Calendar.getInstance()
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = SimpleDateFormat("MMM", Locale.FRENCH).format(calendar.time)
        val year = calendar.get(Calendar.YEAR)
        val currentDate = "Le $dayOfMonth $month $year"
        val randomTotalSpent = String.format("%.2f", Random.nextDouble(0.0, 3000.0)).toDouble()
        val refundValue = String.format("%.2f", randomTotalSpent * 0.2).toDouble()
        return PreviousTripModel(randomCountry, currentDate, randomTotalSpent, refundValue)
    }
}