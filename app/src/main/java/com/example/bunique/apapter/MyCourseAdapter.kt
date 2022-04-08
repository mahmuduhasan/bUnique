package com.example.bunique.apapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bunique.data.MyCourse
import com.example.bunique.databinding.MyCourseViewBinding

class MyCourseAdapter : ListAdapter<MyCourse, MyCourseAdapter.MyCourseViewHolder>(MyCourseDiffUtil()){
    class MyCourseViewHolder(val binding : MyCourseViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(myCourse : MyCourse){
            binding.myCourse = myCourse
        }
    }

    class MyCourseDiffUtil : DiffUtil.ItemCallback<MyCourse>() {
        override fun areItemsTheSame(oldItem: MyCourse, newItem: MyCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyCourse, newItem: MyCourse): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCourseViewHolder {
        val binding = MyCourseViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyCourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyCourseViewHolder, position: Int) {
        val myCourse = getItem(position)
        holder.bind(myCourse)
    }
}