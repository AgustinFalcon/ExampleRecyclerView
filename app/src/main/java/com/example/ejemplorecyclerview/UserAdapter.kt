package com.example.ejemplorecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorecyclerview.databinding.ItemMainActivityRecyclerviewBinding
import com.example.ejemplorecyclerview.model.User


//class UserAdapter(private val userList: MutableList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    inner class UserViewHolder(private val binding: ItemMainActivityRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.ivUser.setImageResource(user.image)
            binding.tvTitle.text = user.title
            binding.tvDescription.text = user.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemMainActivityRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding = binding)
    }

    //override fun getItemCount(): Int = userList.size
    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList.get(position)// messi, di maria
        holder.bind(user)
    }

}