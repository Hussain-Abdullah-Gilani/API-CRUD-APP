package com.example.simpleget



data class UserList(val data: List<User>)
data class User(
    val email: String,
    val gender: String,
    val id: String,
    val name: String,
    val status: String


)

data class UserName(val name: String, val email: String,val gender: String,val status: String)

