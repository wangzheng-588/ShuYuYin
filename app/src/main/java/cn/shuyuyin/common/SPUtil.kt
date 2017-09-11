package cn.shuyuyin.common

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by wz on 17-4-18.
 * QQ:1136918218
 * 微信：wz1136918218
 * 作用：SP工具类
 */

object SPUtil {

    fun putBoolean(context: Context, key: String, value: Boolean) {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putBoolean(key, value)
        edit.apply()
    }

    fun putString(context: Context, key: String, value: String) {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putString(key, value)
        edit.apply()
    }

    fun putInt(context: Context, key: String, value: Int) {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putInt(key, value)
        edit.apply()
    }

    fun putFloat(context: Context, key: String, value: Float) {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putFloat(key, value)
        edit.apply()
    }

    fun getString(context: Context, key: String, defVal: String): String {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val string = sp.getString(key, defVal)
        return string
    }

    fun getBoolean(context: Context, key: String, defVal: Boolean): Boolean {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val result = sp.getBoolean(key, defVal)
        return result
    }


    fun getInt(context: Context, key: String, defVal: Int): Int {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        val result = sp.getInt(key, defVal)
        return result
    }


    fun clearAllCache(context: Context) {
        val sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
        sp.edit().clear().apply()
    }

}
