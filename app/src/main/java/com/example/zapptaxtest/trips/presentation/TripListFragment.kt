package com.example.zapptaxtest.trips.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zapptaxtest.databinding.FragmentTripListBinding
import com.example.zapptaxtest.trips.presentation.adapters.CurrentTripAdapter
import com.example.zapptaxtest.trips.presentation.adapters.PreviousTripAdapter


class TripListFragment : Fragment() {
    private lateinit var binding: FragmentTripListBinding
    private lateinit var currentTripAdapter: CurrentTripAdapter
    private lateinit var previousTripAdapter: PreviousTripAdapter
    private lateinit var viewModel: TripListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Voyages"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(TripListViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews()
        initAdapters()

        viewModel.currentTripList.observe(viewLifecycleOwner) { trips ->
            currentTripAdapter.updateData(trips)
        }

        binding.addButton.setOnClickListener {
            viewModel.addNewTrip()
        }
    }
    private fun initRecyclerViews() {
        val currentLayoutManager = LinearLayoutManager(requireContext())
        binding.currentListRecyclerView.layoutManager = currentLayoutManager

        val previousLayoutManager = LinearLayoutManager(requireContext())
        binding.previousListRecyclerView.layoutManager = previousLayoutManager
    }

    private fun initAdapters() {
        currentTripAdapter = CurrentTripAdapter(requireContext(), viewModel.currentTripList.value ?: emptyList())
        previousTripAdapter = PreviousTripAdapter(requireContext(), viewModel.previousTripList.value ?: emptyList())

        binding.currentListRecyclerView.adapter = currentTripAdapter
        binding.previousListRecyclerView.adapter = previousTripAdapter
    }
}