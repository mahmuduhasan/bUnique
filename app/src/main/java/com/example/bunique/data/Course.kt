package com.example.bunique.data

data class Course(
    val id: Int,
    val name: String,
    val tutorName: String,
    val category : String,
    val uploadDate: String
)

val courseList = listOf<Course>(
    Course(1,"MERN Stack Web development","Ikramul Haque","Web Development","11/12/2023"),
    Course(2,"Android Development Basic","Mahmudul Hasan","Web Development","11/12/2023"),
    Course(3,"Clothing","Radbin Ayub","Web Development","11/12/2023"),
    Course(4,"BCS Preparation","Mahedi Hasan","Web Development","11/12/2023"),
    Course(5,"Business","Imrul Aripin","Web Development","11/12/2023"),
    Course(6,"Computer Oparate","Hridoy Pradhan","Web Development","11/12/2023"),
)