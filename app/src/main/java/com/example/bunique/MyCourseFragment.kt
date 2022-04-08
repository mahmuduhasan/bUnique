package com.example.bunique

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bunique.apapter.MyCourseAdapter
import com.example.bunique.data.myCourseList
import com.example.bunique.databinding.FragmentMyCourseBinding

class MyCourseFragment : Fragment() {
    private lateinit var binding : FragmentMyCourseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCourseBinding.inflate(inflater,container,false)

        val adapter = MyCourseAdapter()

        binding.myCourseRecycleView.layoutManager = LinearLayoutManager(activity)
        binding.myCourseRecycleView.adapter = adapter

        adapter.submitList(myCourseList)

        binding.logout.setOnClickListener {
            findNavController().navigate(R.id.action_myCourseFragment_to_loginFragment)
        }

        return binding.root
    }

}