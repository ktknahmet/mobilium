package com.ktknahmet.mobilium.utils

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.crazylegend.kotlinextensions.isNull
import com.google.gson.Gson
import com.ktknahmet.mobilium.services.NetworkResult
import com.skydoves.whatif.whatIfNotNull
import com.squareup.picasso.Picasso
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


fun Fragment.navigate(id: Int, args: Bundle? = null) {
    this.findNavController().navigate(id, args)
}

fun Fragment.popBackStack() {
    this.findNavController().popBackStack()
}

fun CompoundButton.onCheck(onChecked: (Boolean) -> Unit) {
    setOnCheckedChangeListener { _, isChecked ->
        onChecked(isChecked)
    }
}
fun <T> SingleLiveEvent<NetworkResult<T>>.myObserve(
    viewLifecycleOwner: LifecycleOwner,
    success: (T) -> Unit,
    empty: () -> Unit = {},
    error: (msg: String) -> Unit
) {
    this.observe(
        viewLifecycleOwner
    ) {
        it?.let {
            when (it) {
                is NetworkResult.Success -> {
                    success(it.data)
                }
                is NetworkResult.Empty -> {
                    empty()
                }
                is NetworkResult.Error -> {
                    error(it.message)
                }
            }
        }
    }
}

fun <T> MutableLiveData<NetworkResult<T>>.myObserve(
    viewLifecycleOwner: LifecycleOwner,
    success: (T) -> Unit,
    empty: () -> Unit = {},
    error: (msg: String) -> Unit
) {
    this.observe(
        viewLifecycleOwner
    ) {
        it?.let {
            when (it) {
                is NetworkResult.Success -> success(it.data)
                is NetworkResult.Empty -> empty()
                is NetworkResult.Error -> error(it.message)
            }
        }
    }
}

fun MutableLiveData<Boolean>.observeProgress(
    viewLifecycleOwner: LifecycleOwner,
    pgBar: View
) {
    this.observe(
        viewLifecycleOwner
    ) {
        pgBar.visibility = if (it) View.VISIBLE else View.INVISIBLE
    }
}
fun <T> Response<T>.getData(dataLoading: MutableLiveData<Boolean>, result: (NetworkResult<T>) -> Unit) {
    try {
        dataLoading.value = false
        if (this.isSuccessful) {
            val data = this.body()
            data.whatIfNotNull {
                when (it) {
                    is List<*> -> if (it.isEmpty()) result(NetworkResult.Empty()) else result(NetworkResult.Success(it))
                    is ArrayList<*> -> if (it.isEmpty()) {
                        result(NetworkResult.Empty())
                    } else {
                        result(NetworkResult.Success(it))
                    }
                    is String -> if (it.isEmpty()) {
                        result(NetworkResult.Empty())
                    } else {
                        result(NetworkResult.Success(it))
                    }
                    is Int -> result(NetworkResult.Success(it))
                    else -> if (it.isNull) {
                        result(NetworkResult.Empty())
                    } else {
                        result(NetworkResult.Success(it))
                    }
                }
            }
        } else {
            var message = this.message()
            this.errorBody().whatIfNotNull {
                message = it.string()
            }
            try{
                val json = Gson()

            }
            catch (e:Exception)
            {
                result(NetworkResult.Error("Hata : $message"))
            }
        }
    } catch (e: Exception) {
        Log.e("gelen hata ", e.stackTraceToString())
        Log.e("gelen hata ", e.toString())
        dataLoading.value = false

    }
}
fun dateFormat2(value: String): String {
    var result = ""
    try {
        if (value.isNotEmpty()) {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            sdf.timeZone = TimeZone.getTimeZone("UTC")
            val calendar = Calendar.getInstance()
            calendar.time = sdf.parse(value)!!
            val returnFormat = SimpleDateFormat("dd.MM.yyyy", Locale.forLanguageTag("tr"))
            result = returnFormat.format(calendar.time)
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }

    return result
}
@BindingAdapter("android:showUrl")
fun showImage(view: ImageView,url:String?){
    Picasso.get().load(AppConstants.POSTER_BASEURL+url).into(view)
}

@BindingAdapter("android:showDate")
fun showDate(view: TextView,date:String?){
    view.text = dateFormat2(date.toString())
}





