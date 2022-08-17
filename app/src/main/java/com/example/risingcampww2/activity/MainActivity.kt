package com.example.risingcampww2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.risingcampww2.databinding.ActivityMainBinding
import com.example.risingcampww2.model.UserInfo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val userInfo = intent.getSerializableExtra("userInfo") as UserInfo?

        Log.d("getintent", userInfo?.id ?: "")
        Log.d("getintent", userInfo?.password ?: "")
        Log.d("getintent", userInfo?.name ?: "")
    }


}