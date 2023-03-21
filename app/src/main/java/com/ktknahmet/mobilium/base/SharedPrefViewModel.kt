package com.ktknahmet.mobilium.base

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.ktknahmet.mobilium.utils.MainSharedPreferences
import javax.inject.Inject


class SharedPrefViewModel @Inject constructor(
    private val sharedPreferences: MainSharedPreferences,
) : ViewModel() {
    fun clearPrefs() {
        sharedPreferences.clear()
    }

    fun getSharedBoolean(key: String, defaultValue: Boolean = false): Boolean = sharedPreferences.getBoolean(key, defaultValue)
    fun getSharedInt(key: String, defaultValue: Int = 0): Int = sharedPreferences.getInt(key, defaultValue)
    fun getSharedString(key: String): String = sharedPreferences.getData(key)
    fun setSharedData(key: String, item: String?) {
        sharedPreferences.storeString(key, item)
    }

    fun setSharedData(key: String, item: Int) {
        sharedPreferences.storeInt(key, item)
    }

    fun setSharedData(key: String, item: Boolean) {
        sharedPreferences.storeBoolean(key, item)
    }

    fun setSharedData(key: String, item: Parcelable) {
        sharedPreferences.storeObject(key, item)
    }

    fun <T> setSharedData(key: String, item: ArrayList<T>) {
        sharedPreferences.storeObject(key, item)
    }

    fun MainSharedPreferences.getData(key: String): String {
        var result = ""
        this.getString(key)?.let { result = it }
        return result
    }
}
