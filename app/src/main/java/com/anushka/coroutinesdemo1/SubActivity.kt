package com.anushka.coroutinesdemo1

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SubActivity : AppCompatActivity(){
    private lateinit var subActivityViewModel : SubActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        subActivityViewModel = ViewModelProvider(this).get(SubActivityViewModel::class.java)
        subActivityViewModel.getUserData()
        subActivityViewModel.users.observe(this, Observer{myUsers ->
            myUsers.forEach{
                Log.i("MyTag", " name is ${it.name}")
            }
        })

    }
}