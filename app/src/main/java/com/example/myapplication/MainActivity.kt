package com.example.myapplication

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

  private val liveName = MutableLiveData<String>()

  private lateinit var locationHelper: LocationHelper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val observer: Observer<String> = Observer { a_main_txt.text = it }
    liveName.observe(this, observer)

    a_main_modify.setOnClickListener { liveName.value = Date().toString() }

    locationHelper = LocationHelper(this)
    locationHelper.observe(this, Observer { println("TAG_ $it") })
  }
}
