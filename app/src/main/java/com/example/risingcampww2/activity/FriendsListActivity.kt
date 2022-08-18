package com.example.risingcampww2.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Switch
import com.example.risingcampww2.MyApplication
import com.example.risingcampww2.R
import com.example.risingcampww2.databinding.ActivityFriendsListBinding
import com.example.risingcampww2.databinding.ActivityJoinBinding

class FriendsListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFriendsListBinding
    private var password = ""
    private var inputPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setButtonOnClickListener()
    }

    override fun onStart() {
        super.onStart()

        password = MyApplication.prefs.getUser(MyApplication.userPrefsName).secondPassword
    }

    override fun onResume() {
        super.onResume()

        binding.dimView.visibility = View.GONE
        if (MyApplication.prefs.getBoolean(MyApplication.isBackground)) {
            binding.llFriendPassword.visibility = View.VISIBLE
        }
        MyApplication.prefs.clearBoolean()
    }

    override fun onPause() {
        super.onPause()

        binding.dimView.visibility = View.VISIBLE
    }

    override fun onStop() {
        super.onStop()

        MyApplication.prefs.setBoolean(MyApplication.isBackground, true)
    }

    override fun onDestroy() {
        super.onDestroy()

        MyApplication.prefs.clearUser()
        MyApplication.prefs.clearBoolean()
    }

    private fun setButtonOnClickListener() {
        binding.btnKakaoPassword.setOnClickListener {
            clickNumberButton("1")
        }
        binding.btnKakaoPassword2.setOnClickListener {
            clickNumberButton("2")
        }
        binding.btnKakaoPassword3.setOnClickListener {
            clickNumberButton("3")
        }
        binding.btnKakaoPassword4.setOnClickListener {
            clickNumberButton("4")
        }
        binding.btnKakaoPassword5.setOnClickListener {
            clickNumberButton("5")
        }
        binding.btnKakaoPassword6.setOnClickListener {
            clickNumberButton("6")
        }
        binding.btnKakaoPassword7.setOnClickListener {
            clickNumberButton("7")
        }
        binding.btnKakaoPassword8.setOnClickListener {
            clickNumberButton("8")
        }
        binding.btnKakaoPassword9.setOnClickListener {
            clickNumberButton("9")
        }
        binding.btnKakaoPassword0.setOnClickListener {
            clickNumberButton("0")
        }
        binding.btnKakaoPasswordBackspace.setOnClickListener {
            removeNumber()
        }
        binding.ivFriendLogout.setOnClickListener {
            finish()
        }
    }

    private fun clickNumberButton(number: String) {
        when (inputPassword.length) {
            0 -> binding.ivFriendPw1.setImageResource(R.drawable.password_yellowcircle)
            1 -> binding.ivFriendPw2.setImageResource(R.drawable.password_yellowcircle)
            2 -> binding.ivFriendPw3.setImageResource(R.drawable.password_yellowcircle)
            3 -> binding.ivFriendPw4.setImageResource(R.drawable.password_yellowcircle)
        }
        inputPassword += number
        if (inputPassword.length == 4) {
            checkPassword()
        }
    }

    private fun removeNumber() {
        if (inputPassword.isNotEmpty()) {
            when (inputPassword.length) {
                1 -> binding.ivFriendPw1.setImageResource(R.drawable.password_underbar1)
                2 -> binding.ivFriendPw2.setImageResource(R.drawable.password_underbar1)
                3 -> binding.ivFriendPw3.setImageResource(R.drawable.password_underbar1)
                4 -> binding.ivFriendPw4.setImageResource(R.drawable.password_underbar1)
            }
            inputPassword = inputPassword.substring(0, inputPassword.length - 1)
        }
    }

    private fun checkPassword() {
        if (password == inputPassword) {
            binding.llFriendPassword.visibility = View.GONE
        }
        binding.ivFriendPw1.setImageResource(R.drawable.password_underbar1)
        binding.ivFriendPw2.setImageResource(R.drawable.password_underbar1)
        binding.ivFriendPw3.setImageResource(R.drawable.password_underbar1)
        binding.ivFriendPw4.setImageResource(R.drawable.password_underbar1)
        inputPassword = ""
    }
}