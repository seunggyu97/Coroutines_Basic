package com.anushka.coroutinesdemo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch{
//                tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
                tvUserMessage.text = UserDataManager2().getTotalUserCount().toString()
            }
        }
        btnSubActivity.setOnClickListener{
            var intent: Intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        mainActivityViewModel.getUsers()
        mainActivityViewModel.users.observe(this, Observer { myUsers ->
            myUsers.forEach{
                Log.i("MyTag", "이름은 ${it.name} 입니다.")
            }
        })

    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            // 메인 스레드로 전환
            withContext(Dispatchers.Main){
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}";
            }
        }
    }
}
