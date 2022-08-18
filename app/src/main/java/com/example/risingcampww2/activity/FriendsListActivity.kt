package com.example.risingcampww2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingcampww2.R
import com.example.risingcampww2.databinding.ActivityFriendsListBinding
import com.example.risingcampww2.databinding.ActivityJoinBinding

class FriendsListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFriendsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}