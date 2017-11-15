package com.example.myapplication

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.entities.UserDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

  private lateinit var userDao: UserDao

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val database = Room.databaseBuilder(this, AppDatabase::class.java, "users.db")
        .build()

    userDao = database.userDao()

    a_main_save.setOnClickListener { saveNewUserObservable() }
    a_main_load.setOnClickListener { loadUsers() }
  }

  private fun saveNewUserObservable() {
    Observable.fromCallable({ saveNewUser() })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ println(it) })
  }

  private fun saveNewUser(): List<Long> {
    val user = User("Edwin", Date().time)
    return userDao.insertAll(user)
  }

  private fun loadUsers() {
    userDao.findAll()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(Consumer { it.forEach { println(it) } })
  }
}
