package com.example.edna.ui.utilities

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.edna.databinding.FragmentUtilitiesBinding


class UtilitiesFragment : Fragment() {

    private var _binding: FragmentUtilitiesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(UtilitiesViewModel::class.java)

        _binding = FragmentUtilitiesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val vmodel: UtilitiesViewModel by viewModels()

        /*
        val textView: TextView = binding.textUtilities
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

         */

        val button1: Button = binding.hyperflushButton
        button1.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            Log.d("Utilities", "Hyperflush requested in utilities")
            val result = vmodel.requestHyperflush()
        })

        val button2: Button = binding.rtcButton
        button2.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            Log.d("Utilities", "RTC Update requested in utilities")
            val result = vmodel.requestRTCUpdate()
        })

        val button3: Button = binding.valvesButton
        button3.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            Log.d("Utilities", "Valve reset requested in utilities")
            val result = vmodel.requestValveReset()
        })

        val button4: Button = binding.bubbleButton
        button4.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            Log.d("TAG", "Bubble Purge requested in utilities")
            val result = vmodel.requestBubblePurge()
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}