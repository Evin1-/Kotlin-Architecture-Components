package com.example.myapplication

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private lateinit var timerViewModel: TimerViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    timerViewModel = ViewModelProviders.of(this).get(TimerViewModel::class.java)

    updateValue()
    a_main_btn.setOnClickListener { updateValue() }
  }

  private fun updateValue() {
    a_main_txt.text = timerViewModel.timerValue.toString()
  }
}
