package com.ceiba.cleanarchitecturekotlin.presentation.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.cleanarchitecturekotlin.R
import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain

class UserAdapter(private val users: ArrayList<UserDomain>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val email: TextView = itemView.findViewById(R.id.tvEmail)
        val phone: TextView = itemView.findViewById(R.id.tvPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_user, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: UserDomain = users[position]
        holder.name.text = user.name
        holder.email.text = user.email
        holder.phone.text = user.phone
    }
}