package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val timerHelper = TimerHelper({ updateTextView(it) })
    lifecycle.addObserver(timerHelper)
  }

  private fun updateTextView(result: String) {
    runOnUiThread { a_main_result.text = result }
  }
}
