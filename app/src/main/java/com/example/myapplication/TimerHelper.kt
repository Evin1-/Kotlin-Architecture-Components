package com.example.myapplication

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Created by user on 11/16/17.
 */

class TimerHelper(private val callback: (String) -> Unit) : LifecycleObserver {

  private val timer: Observable<Long> = Observable.interval(1, TimeUnit.SECONDS)
  private var disposable: Disposable? = null

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  fun connectHelper() {
    println("TAG_ connectHelper!")
    disposable = timer.subscribe { callback(it.toString()) }
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  fun disconnectHelper() {
    println("TAG_ disconnectHelper!")
    disposable?.dispose()
  }
}