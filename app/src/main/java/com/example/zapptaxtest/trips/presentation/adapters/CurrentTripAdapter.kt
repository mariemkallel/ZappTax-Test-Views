package com.example.zapptaxtest.trips.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zapptaxtest.R
import com.example.zapptaxtest.databinding.ItemCurrentTripBinding
import com.example.zapptaxtest.trips.presentation.model.CurrentTripModel

class CurrentTripAdapter(private val context: Context, private var items: List<CurrentTripModel>) :
    RecyclerView.Adapter<CurrentTripAdapter.ViewHolder>() {
    private val countryFlagMap = mapOf(
        "Belgique" to R.drawable.ic_flag_belgium,
        "Espagne" to R.drawable.ic_flag_spain,
        "France" to R.drawable.ic_flag_france
    )

    inner class ViewHolder(private val binding: ItemCurrentTripBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CurrentTripModel) {
            val departureText = context.getString(R.string.departure_from_country, item.country)
            val refundText = context.getString(R.string.refund_value, item.refundValue)
            val totalSpentText = context.getString(R.string.total_spent,item.totalSpent )
            val flagResourceId = countryFlagMap[item.country]
            flagResourceId?.let {
                binding.countryFlagImageView.setImageResource(it)
            }

            binding.countryNameTextView.text = departureText
            binding.refundValueTextView.text = refundText
            binding.totalSpentTextView.text = totalSpentText
            binding.currentDateTextView.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCurrentTripBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateData(newTrips: List<CurrentTripModel>) {
        items = newTrips
        notifyDataSetChanged()
    }
}
