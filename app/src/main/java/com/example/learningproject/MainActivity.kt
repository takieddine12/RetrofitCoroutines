package com.example.learningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learningproject.ApiRequest.AuthApi
import com.example.learningproject.RecylerAdapter.RecylerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        //Adding Dividers to the rows
        recycler.addItemDecoration(DividerItemDecoration(recycler.context,
        LinearLayoutManager.HORIZONTAL))

        //getting response on coroutine backgroud thread
        CoroutineScope(IO).launch {
            val response = AuthApi.getResponse().getPosts()
            withContext(Dispatchers.Main){
                recycler.adapter = RecylerAdapter(response)
            }
        }

    }
}