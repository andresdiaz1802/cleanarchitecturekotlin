package com.ceiba.cleanarchitecturekotlin.presentation.views.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.cleanarchitecturekotlin.R
import com.ceiba.cleanarchitecturekotlin.domain.entities.UserDomain
import com.ceiba.cleanarchitecturekotlin.presentation.interfaces.UserViewModel
import com.ceiba.cleanarchitecturekotlin.presentation.viewmodel.activities.UserViewModelImpl
import com.ceiba.cleanarchitecturekotlin.presentation.views.adapters.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    private lateinit var loading: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: UserAdapter

    private var users: ArrayList<UserDomain> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialObjects()
        initialElements()
        addAdapters()
        initialViewModels()
    }

    private fun initialObjects() {
        adapter = UserAdapter(users)
    }

    private fun initialElements() {
        loading = findViewById(R.id.pbLoading)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun addAdapters() {
        recyclerView.adapter = adapter
    }

    private fun initialViewModels() {
        userViewModel = ViewModelProviders.of(this).get(UserViewModelImpl::class.java)
        userViewModel.getUsersLiveData().observe(this, consultUsers())
        userViewModel.getUsers()
    }

    private fun consultUsers(): Observer<Any> = Observer<Any> {
        val anyList = it as List<*>
        val users = anyList.map { value -> value as UserDomain }
        loading.visibility = if (users.isEmpty())View.VISIBLE else View.GONE
        this.users.addAll(users)
        adapter.notifyDataSetChanged()
    }
}