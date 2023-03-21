package com.ktknahmet.mobilium.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
    private var compositeDisposable: CompositeDisposable? = null
    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable != null) {
            compositeDisposable!!.dispose()
            compositeDisposable!!.clear()
            compositeDisposable = null
        }
    }

    @Suppress("unused")
    protected fun addDisposable(disposable: @NonNull io.reactivex.rxjava3.disposables.Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(disposable)
    }
}