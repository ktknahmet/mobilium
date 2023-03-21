package com.ktknahmet.mobilium.utils


import androidx.fragment.app.Fragment


fun Fragment.te(message: String) {
    ToastMessage.createColorToast(
        this.requireActivity(),
        message,
        ToastMessage.TOAST_ERROR,
        ToastMessage.GRAVITY_TOP,
        ToastMessage.LONG_DURATION
    )
}

fun Fragment.ts(message: String) {
    ToastMessage.createColorToast(
        this.requireActivity(),
        message,
        ToastMessage.TOAST_SUCCESS,
        ToastMessage.GRAVITY_TOP,
        ToastMessage.LONG_DURATION
    )
}

fun Fragment.tw(message: String) {
    ToastMessage.createColorToast(
        this.requireActivity(),
        message,
        ToastMessage.TOAST_WARNING,
        ToastMessage.GRAVITY_TOP,
        ToastMessage.LONG_DURATION
    )
}

fun Fragment.ti(message: String) {
    ToastMessage.createColorToast(
        this.requireActivity(),
        message,
        ToastMessage.TOAST_INFO,
        ToastMessage.GRAVITY_TOP,
        ToastMessage.LONG_DURATION
    )
}
