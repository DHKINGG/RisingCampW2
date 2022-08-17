package com.example.risingcampww2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.risingcampww2.R
import com.example.risingcampww2.databinding.ActivityJoinBinding
import com.example.risingcampww2.model.UserInfo

class JoinActivity : AppCompatActivity() {

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

            if (id.isEmpty() || password.isEmpty() || passwordRecheck.isEmpty() || name.isEmpty()) {
                print("값을 전부 입력해주세요")
            } else {
                if (password == passwordRecheck) {
                    val intent = Intent(this, MainActivity::class.java)
                    val userInfo = UserInfo(id, password, name)
                    intent.putExtra("userInfo", userInfo)
                    startActivity(intent)
                } else {
                    print("패스워드를 확인해주세요.")
                }
            }

        }

    }


}
