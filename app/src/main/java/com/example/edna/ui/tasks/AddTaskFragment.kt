package com.example.edna.ui.tasks

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.edna.R

class AddTaskFragment : Fragment(R.layout.fragment_add_task) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskNameET: EditText = view.findViewById(R.id.task_name_input)
        val taskNotesET: EditText = view.findViewById(R.id.task_notes_input)
        val statusET : EditText = view.findViewById(R.id.status_input)
        val scheduleET: EditText = view.findViewById(R.id.schedule_input)
        val flushTimeET: EditText = view.findViewById(R.id.flush_time_input)
        val flushVolumeET: EditText = view.findViewById(R.id.flush_volume_input)
        val sampleTimeET: EditText = view.findViewById(R.id.sample_time_input)
        val samplePressureET: EditText = view.findViewById(R.id.sample_pressure_input)
        val sampleVolumeET: EditText = view.findViewById(R.id.sample_volume_input)
        val timeBetweenET: EditText = view.findViewById(R.id.time_between_input)
        val valvesOffsetET: EditText = view.findViewById(R.id.valves_offset_input)
        val deleteOnCompletionET: EditText = view.findViewById(R.id.delete_on_completion_input)
        val valvesET: EditText = view.findViewById(R.id.valves_input)

    }

}