package com.example.risingcampww2

import android.app.Application
import com.example.risingcampww2.model.PreferenceUtil

// application 전체에서 sp를 쉽게 가져올수 있도록 Application 클래스를 만들어줌
class MyApplication: Application() {
    companion object {
        lateinit var prefs: PreferenceUtil
        val userListPrefsName = "user_name_list"
        val userPrefsName = "user_name"
        val isBackground = "is_background"
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}