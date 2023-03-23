package com.example.edna.ui.tasks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edna.R
import com.example.edna.databinding.FragmentTasksBinding
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private lateinit var taskListRV: RecyclerView
    private val taskAdapter = TaskListAdapter()
    private val viewModel: TasksViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel =
            ViewModelProvider(this).get(TasksViewModel::class.java)

        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTasks/*
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskListRV = view.findViewById(R.id.rv_task_list)
        taskListRV.layoutManager = LinearLayoutManager(requireContext())
        taskListRV.setHasFixedSize(true)
        taskListRV.adapter = taskAdapter


        val addTaskBtn= view.findViewById<Button>(R.id.btn_add_task)
        addTaskBtn.setOnClickListener {
            val directions = TasksFragmentDirections.navigationToAddTask()
            findNavController().navigate(directions)
        }


        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            if (tasks != null) {
                taskAdapter.updateList(tasks)
                taskListRV.visibility = View.VISIBLE
                taskListRV.scrollToPosition(0)
            }
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}