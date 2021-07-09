package com.diwaves.news.tools

import android.content.Context
import android.content.SharedPreferences


class SPToll(context: Context) {
    val NAME = "SPSzh"
    val ID = "id"
    val FRIST = "frist"
    val PHONE = "phone"
    val PASSWORD = "password"
    val TOKEN = "token"
    var preferences: SharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = preferences.edit() //获取编辑器
    fun getId(): String {
        return preferences.getString(ID, "").toString()
    }

    fun setId(id: String) {
        editor.putString(ID, id);
        editor.commit()
    }

    fun getPhone(): String {
        return preferences.getString(PHONE, "").toString()
    }

    fun setPhone(phone: String) {
        editor.putString(PHONE, phone);
        editor.commit()
    }

    fun getPassword(): String {
        return preferences.getString(PASSWORD, "").toString()
    }

    fun getFrist(): Boolean {
        return preferences.getBoolean(FRIST, true)
    }

    fun setFrist(){
        editor.putBoolean(FRIST, false);
        editor.commit()
    }

    fun setPassWord(password: String) {
        editor.putString(PASSWORD, password);
        editor.commit()
    }

    fun setToken(token: String) {
        editor.putString(TOKEN, token);
        editor.commit()
    }

    fun getToken(): String {
        return preferences.getString(TOKEN, "").toString()
    }

}