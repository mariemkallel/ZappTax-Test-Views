package com.example.zapptaxtest.trips.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zapptaxtest.R
import com.example.zapptaxtest.databinding.ItemPreviousTripBinding
import com.example.zapptaxtest.trips.presentation.model.PreviousTripModel


class PreviousTripAdapter(private val context: Context, private var items: List<PreviousTripModel>) :
    RecyclerView.Adapter<PreviousTripAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPreviousTripBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PreviousTripModel) {
            val departureText = context.getString(R.string.departure_from_country, item.country)
            val refundText = context.getString(R.string.refund_value, item.refundValue)
            val totalSpentText = context.getString(R.string.total_spent, item.totalSpent)
            binding.countryNameTextView.text = departureText
            binding.refundValueTextView.text = refundText
            binding.totalSpentTextView.text = totalSpentText
            binding.currentDateTextView.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPreviousTripBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
