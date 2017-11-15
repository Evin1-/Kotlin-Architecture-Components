package com.example.myapplication.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by user on 11/15/17.
 */

@Entity
data class User(val name: String, val dateModified: Long) {
  @PrimaryKey(autoGenerate = true)
  var _id: Long = 0
}