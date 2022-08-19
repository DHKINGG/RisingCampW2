package com.example.risingcampww2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.risingcampww2.MyApplication
import com.example.risingcampww2.databinding.ActivityMainBinding
import com.example.risingcampww2.model.UserInfo

class MainActivity : AppCompatActivity() {
    private var userList: MutableList<UserInfo> = mutableListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.kakaoId.setOnClickListener {
            MyApplication.prefs.clearUserList()
        }

        binding.btnLogin.setOnClickListener {
            if(checkUser(binding.etLoginId.text.toString(), binding.etLoginPassword.text.toString())) {
                val intent = Intent(this,FriendsListActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this@MainActivity, "아이디 혹은 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnJoin.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        getUserList()
    }

    // userList에 sp에서 리스트를 가져와서 저장

    private fun getUserList() {
        userList = MyApplication.prefs.getUserList(MyApplication.userListPrefsName)
    }

    // user정보가 맞으면 true 아니면 false
    private fun checkUser(id: String, pw: String): Boolean {
        for (i in 0 until userList.size) {
            if (id == userList[i].id && pw == userList[i].password) {
                MyApplication.prefs.setUser(MyApplication.userPrefsName, userList[i])
                return true
            }
        }
        return false
    }
}