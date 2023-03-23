package com.example.edna.ui.tasks

import android.text.Layout
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.edna.R
import java.text.SimpleDateFormat
import java.util.*


class TaskListAdapter(): Adapter<TaskListAdapter.TaskViewHolder>(){
    //var tasks: MutableList<Tasks> = mutableListOf()

    var tasks: List<Tasks> = listOf()

    //taskList: mutableList<Tasks>)[
    fun updateList(taskList: List<Tasks>){
        tasks = taskList
        notifyDataSetChanged()
    }

    override fun getItemCount() = tasks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_list_item, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }
/*
    fun addTask(task: Tasks){
        tasks.add(0, task)
        notifyItemInserted(0)
    }
*/
    class TaskViewHolder(view: View): ViewHolder(view){
        private val nameTV: TextView = itemView.findViewById(R.id.tv_task_name)
        private val notesTV: TextView = itemView.findViewById(R.id.tv_task_notes)
        private val valvesTV: TextView = itemView.findViewById(R.id.tv_valves)
        private val scheduleTV: TextView = itemView.findViewById(R.id.tv_schedule)


        fun bind(tasks: Tasks) {
            val cal = Calendar.getInstance()
            cal.timeInMillis = tasks.schedule.toLong() * 1000

            val dateFormat = SimpleDateFormat("h:mm a")
            val timeString = dateFormat.format(tasks.schedule.toLong()*1000)

            scheduleTV.text = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) +
                    " " + cal.get(Calendar.DAY_OF_MONTH).toString() + " " + timeString


            val temp = mutableListOf<String>()
            nameTV.text = tasks.name
            notesTV.text = tasks.notes
            for (i in tasks.valves.indices){
                temp.add(tasks.valves[i].toString())
            }
            val separator = ", "
            valvesTV.text = "Valves: " + temp.joinToString(separator)

        }

    }
}