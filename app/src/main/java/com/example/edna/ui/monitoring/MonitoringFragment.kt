package com.example.edna.ui.monitoring

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edna.R
import com.example.edna.databinding.FragmentMonitoringBinding
import java.time.Instant
import java.time.ZoneId
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit


class MonitoringFragment : Fragment(R.layout.fragment_monitoring) {

    private var _binding: FragmentMonitoringBinding? = null
    private val viewModel: MonitoringViewModel by viewModels()
    private val statusAdapter = ValveStatusAdapter()

    private val defaultValveStatus: MutableList<Int> = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)

    private val scheduler = Executors.newSingleThreadScheduledExecutor()

    private lateinit var valveStatusRV: RecyclerView
    private lateinit var future: Future<*>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val beeper = Runnable { viewModel.loadSearchResults() }
        future = scheduler.scheduleAtFixedRate(beeper, 5, 2, TimeUnit.SECONDS)


        //view.findViewById<Button>(R.id.button).setBackgroundColor(Color.RED)
        //view.findViewById<Button>(R.id.button).text = "3"

        valveStatusRV = view.findViewById(R.id.Status_RV)
        valveStatusRV.layoutManager = LinearLayoutManager(requireContext())
        valveStatusRV.setHasFixedSize(true)
        valveStatusRV.adapter = statusAdapter

        statusAdapter.updateStatus(defaultValveStatus)

        viewModel.statusResults.observe(this) { status ->

            if(status != null) {
                status?.utc?.let {

                    view!!.findViewById<TextView>(R.id.UTC_TV).text =
                        Instant.ofEpochSecond(it.toLong()).atZone(ZoneId.systemDefault()).toLocalDateTime()
                            .toString()

                }

                if(status.lowBattery){
                    view.findViewById<ImageView>(R.id.Battery_IV).setImageResource(R.drawable.battery_alert)
                } else {
                    view.findViewById<ImageView>(R.id.Battery_IV).setImageResource(R.drawable.battery_full)
                }

                statusAdapter.updateStatus(status.valves as MutableList<Int>)
                view.findViewById<TextView>(R.id.Pressure_TV).text =
                    "Pressure: ${status.pressure} PSI"
                view.findViewById<TextView>(R.id.Temperature_TV).text =
                    "Temperature: ${status.temperature} C"
                view.findViewById<TextView>(R.id.Volume_TV).text = "Volume: ${status.waterFlow} mL"
                view.findViewById<TextView>(R.id.Flow_TV).text = "Flow: ${status.waterFlow} mL/min"
                view.findViewById<TextView>(R.id.State_TV).text =
                    "Current State: ${status.currentState}"
            }

        }
    }

    override fun onDestroyView() {
        Log.d("Monitor", "Deleting")
        future.cancel(true)
        super.onDestroyView()
        _binding = null
    }

}