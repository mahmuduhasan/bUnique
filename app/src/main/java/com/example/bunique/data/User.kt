package com.example.bunique.data

data class User(
    val id : Long,
    val name : String,
    val email : String,
    val country : String,
    val institute : String,
    val interest : String,
    val password : String
)

val userList = mutableListOf<User>(

)
