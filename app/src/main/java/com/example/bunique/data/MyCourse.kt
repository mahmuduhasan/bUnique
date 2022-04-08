package com.example.bunique.data

data class MyCourse(
    val id: Long,
    val name: String,
    val takenDate: String = "12/12/2023"
)

val myCourseList = mutableListOf<MyCourse>()
