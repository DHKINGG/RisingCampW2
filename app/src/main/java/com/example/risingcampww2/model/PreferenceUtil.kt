package com.example.risingcampww2.model

import android.content.Context
import android.content.SharedPreferences
import com.example.risingcampww2.MyApplication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferenceUtil(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("my_pref", Context.MODE_PRIVATE)

    // gson : object에서 json으로, json에서 object로 바꿔주는 도구
    // json : 데이터가 string화 된 것

    fun getUserList(key: String): MutableList<UserInfo> {
        val json = prefs.getString(key, "").toString()    // sp에서 꺼내옴
        val gson = Gson()
        val token: TypeToken<MutableList<UserInfo>> = object : TypeToken<MutableList<UserInfo>>(){} // 어떤타입의 토큰을 가져올건지
        val userList: MutableList<UserInfo>? = gson.fromJson(json, token.type)   // gson을 사용해서 json을 object로 바꿈

        if (userList == null) {
            return mutableListOf()
        } else {
            return userList
        }
    }

    fun setUserList(key: String, listObject: MutableList<UserInfo>) {
        val gson = Gson()
        val json: String = gson.toJson(listObject)    // gson을 사용해서 object를 json으로 바꿈
        prefs.edit().putString(key, json).apply()   // sp에 저장
    }

    fun getUser(key: String): UserInfo {
        val json = prefs.getString(key, "").toString()    // sp에서 꺼내옴
        val gson = Gson()
        val token: TypeToken<UserInfo> = object : TypeToken<UserInfo>(){} // 어떤타입의 토큰을 가져올건지
        if (json.isEmpty()) {
            return UserInfo("","","","")
        }
        val user: UserInfo = gson.fromJson(json, token.type)   // gson을 사용해서 json을 object로 바꿈
        return user
    }

    fun setUser(key: String, listObject: UserInfo) {
        val gson = Gson()
        val json: String = gson.toJson(listObject)    // gson을 사용해서 object를 json으로 바꿈
        prefs.edit().putString(key, json).apply()   // sp에 저장
    }

    fun clearUserList() {
        prefs.edit().remove(MyApplication.userListPrefsName).commit()
    }

    fun clearUser() {
        prefs.edit().remove(MyApplication.userPrefsName).commit()
    }

    fun clearBoolean() {
        prefs.edit().remove(MyApplication.isBackground).commit()
    }

    fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    fun setBoolean(key: String, bool: Boolean) {
        prefs.edit().putBoolean(key, bool).apply()
    }
}