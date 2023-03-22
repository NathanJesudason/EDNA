package com.example.edna.ui.monitoring

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edna.R

class ValveStatusAdapter : RecyclerView.Adapter<ValveStatusAdapter.ViewHolder>() {
    var Statuses: List<Int> = listOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.Statuses[position], position)
    }

    override fun getItemCount() = this.Statuses.size

    fun updateStatus(statuses: MutableList<Int>){
        Statuses = statuses
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.valve_list_item, parent, false)
        return ViewHolder(view)

    }

    class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
            private val valveTV: TextView = itemView.findViewById(R.id.tv_valve)
            private lateinit var currentStatus: String



        fun bind(valveStatus: Int, valve: Int){
            currentStatus = when (valveStatus) {
                1 -> {
                    "${valve.toString()}: Free"
                }
                0 -> {
                    "${valve.toString()}: Sampled"
                }
                else -> {
                    "${valve.toString()}: Unavailable"
                }
            }
            valveTV.text = currentStatus
        }
    }
}