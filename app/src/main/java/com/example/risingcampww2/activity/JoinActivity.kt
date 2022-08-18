package com.example.risingcampww2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.risingcampww2.MyApplication
import com.example.risingcampww2.R
import com.example.risingcampww2.databinding.ActivityJoinBinding
import com.example.risingcampww2.model.UserInfo

class JoinActivity : AppCompatActivity() {
    private var userList: MutableList<UserInfo> = mutableListOf()

    private lateinit var binding: ActivityJoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonJoinComplete.setOnClickListener {
            val id = binding.etInputId.text.toString()
            val password = binding.etInputPassword.text.toString()
            val passwordRecheck = binding.etInputPasswordRecheck.text.toString()
            val name = binding.etInputName.text.toString()
            val secondPassword = binding.etInputScreenPassword.text.toString()

            if (id.isEmpty() || password.isEmpty() || passwordRecheck.isEmpty() || name.isEmpty()) {
                Toast.makeText(this@JoinActivity, "항목을 전부 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else {
                if (findOverlapId(id)) {
                    Toast.makeText(this@JoinActivity, "아이디 중복입니다.", Toast.LENGTH_SHORT).show()
                }
                else if (secondPassword.length != 4) {
                    Toast.makeText(this@JoinActivity, "4자리의 2차비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                else if (password == passwordRecheck) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    // ABCDE에서 C를 CLEAR_TOP으로 불러오면 ABCDE -> ABC가 됨
                    val userInfo = UserInfo(id, password, name, secondPassword)
                    setUserList(userInfo)   // SP에 userList 저장
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this@JoinActivity, "패스워드를 확인해주세요.", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    // onStart에선 네트워크통신을 통해 데이터를 가져올 때 자주쓰이므로 sp에서 데이터를 가져올 때 사용했음
    override fun onStart() {
        super.onStart()

        getUserList()
    }

    // userList에 sp에서 리스트를 가져와서 저장
    private fun getUserList() {
        userList = MyApplication.prefs.getUserList(MyApplication.userListPrefsName)
    }

    // 중복되는 아이디가 있으면 true 없으면 false
    private fun findOverlapId(id: String):Boolean {
        for (i in 0 until userList.size) {
            if (userList[i].id == id) {
                return true
            }
        }
        return false
    }

    // 입력한 user데이터를 sp에 추가
    private fun setUserList(user: UserInfo) {
        userList.add(user)
        MyApplication.prefs.setUserList(MyApplication.userListPrefsName, userList)
    }
}
