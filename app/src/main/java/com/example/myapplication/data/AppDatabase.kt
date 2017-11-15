package com.example.myapplication.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.myapplication.data.entities.User
import com.example.myapplication.data.entities.UserDao

/**
 * Created by user on 11/15/17.
 */

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userDao(): UserDao
}