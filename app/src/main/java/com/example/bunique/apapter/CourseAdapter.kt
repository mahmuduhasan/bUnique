package com.example.bunique.apapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bunique.data.Course
import com.example.bunique.data.MyCourse
import com.example.bunique.data.myCourseList
import com.example.bunique.databinding.CourseViewBinding

class CourseAdapter(val callBack : (Course) -> Unit) : ListAdapter<Course, CourseAdapter.CourseViewHolder>(CourseDiffUtil()) {
    class CourseViewHolder(val binding : CourseViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(course : Course){
            binding.course = course
        }
    }

    class CourseDiffUtil : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = CourseViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        holder.bind(course)

        val myCourse = MyCourse(
            id = System.currentTimeMillis(),
            name = course.name,

        )

        holder.binding.enroll.setOnClickListener {
            callBack(course)
            myCourseList.add(myCourse)
        }
    }
}