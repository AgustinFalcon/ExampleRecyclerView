package com.example.ejemplorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemplorecyclerview.databinding.ActivityMainBinding
import com.example.ejemplorecyclerview.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userList = mutableListOf<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        userViewModel.recyclerList.observe(this) { userListObserver ->
            val userAdapter = UserAdapter(userListObserver)
            binding.recyclerviewUser.layoutManager = LinearLayoutManager(this)
            binding.recyclerviewUser.adapter = userAdapter
        }



        //val userAdapter = UserAdapter(userList = userList)
        //binding.recyclerviewUser.layoutManager = LinearLayoutManager(this)
        //binding.recyclerviewUser.adapter = userAdapter

        binding.btnAdd.setOnClickListener {
            //addUser(userAdapter)
            userViewModel.addUser()
        }

        binding.btnDelete.setOnClickListener {
            //deleteUser(userAdapter)
            userViewModel.deleteUser()
        }
    }

    private fun deleteUser(userAdapter: UserAdapter) {
        if (userList.isNotEmpty()) {
            userList.removeAt(userList.size - 1)
            userAdapter.notifyItemRemoved(userList.size)
        }
    }

    private fun addUser(userAdapter: UserAdapter) {
        val newUser = createUser()
        userList.add(newUser)
        userAdapter.notifyItemInserted(userList.size - 1)
    }

    private fun createUser(): User {
        return User(image = R.drawable.fideo, title = "Fideo Crack", "Fideo campeon del mundo - 2022")
    }
}