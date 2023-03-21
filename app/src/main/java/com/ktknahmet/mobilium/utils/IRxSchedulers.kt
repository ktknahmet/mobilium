package com.ktknahmet.mobilium.utils

import io.reactivex.rxjava3.core.Scheduler

interface IRxSchedulers {
    fun main(): Scheduler
    fun io(): Scheduler
}