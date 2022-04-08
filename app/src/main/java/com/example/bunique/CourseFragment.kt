package com.example.bunique

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bunique.apapter.CourseAdapter
import com.example.bunique.data.Course
import com.example.bunique.data.courseList
import com.example.bunique.databinding.FragmentCourseBinding

class CourseFragment : Fragment() {

    private lateinit var binding : FragmentCourseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater,container,false)
        val adapter = CourseAdapter(::onClickEnroll)
        binding.courseRecycleView.layoutManager = LinearLayoutManager(activity)
        binding.courseRecycleView.adapter = adapter
        adapter.submitList(courseList)

        binding.logout.setOnClickListener {
            findNavController().navigate(R.id.action_courseFragment_to_loginFragment)
        }

        binding.profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_courseFragment_to_myCourseFragment)
        }
        return binding.root
    }
    
    fun onClickEnroll(course : Course){
        Toast.makeText(activity, "${course.name} Enrolled Successfully!", Toast.LENGTH_SHORT).show()
    }

}