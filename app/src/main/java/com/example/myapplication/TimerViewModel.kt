package com.example.myapplication

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Created by user on 11/16/17.
 */

class TimerViewModel : ViewModel() {

  private val disposable: Disposable?

  var timerValue: Int = 0

  init {
    disposable = Observable.interval(1, TimeUnit.SECONDS)
        .doOnNext { println(it) }
        .subscribe({ timerValue++ })
  }

  override fun onCleared() {
    super.onCleared()

    println("TAG_ onCleared!")
    disposable?.dispose()
  }
}