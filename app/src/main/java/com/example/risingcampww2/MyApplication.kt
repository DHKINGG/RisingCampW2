package com.example.risingcampww2

import android.app.Application
import com.example.risingcampww2.model.PreferenceUtil

// application 전체에서 sp를 쉽게 가져올수 있도록 Application 클래스를 만들어줌
class MyApplication: Application() {
    companion object {  // 어떤 파일에서도 쓸수있게
        lateinit var prefs: PreferenceUtil
        const val userListPrefsName = "user_name_list"
        const val userPrefsName = "user_name"
        const val isBackground = "is_background"
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}