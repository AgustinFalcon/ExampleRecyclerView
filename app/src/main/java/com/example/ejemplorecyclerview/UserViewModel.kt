package com.example.ejemplorecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejemplorecyclerview.model.User


class UserViewModel : ViewModel() {

    val recyclerList = MutableLiveData<List<User>>()

    init {
        recyclerList.value = mutableListOf(createUser())
    }

    fun addUser() {
        recyclerList.value = recyclerList.value?.plus(createUser())
    }

    fun deleteUser() {
        recyclerList.value = recyclerList.value?.dropLast(recyclerList.value?.toList()!!.size-(recyclerList.value?.toList()!!.size-1))
    }

    private fun createUser(): User {
        return User(image = R.drawable.fideo, title = "Fideo Crack", "Fideo campeon del mundo - 2022")
    }
}