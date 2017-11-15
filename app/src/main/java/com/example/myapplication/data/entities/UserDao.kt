package com.example.myapplication.data.entities

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single


/**
 * Created by user on 11/15/17.
 */

@Dao
interface UserDao {
  @Query("SELECT * FROM user")
  fun findAll(): Single<List<User>>

  @Query("SELECT * FROM user WHERE _id IN (:userIds)")
  fun findAllByIds(userIds: IntArray): List<User>

  @Query("SELECT * FROM user WHERE dateModified >= :date")
  fun findAllByDateModified(date: Long): List<User>

  @Insert
  fun insertAll(vararg users: User): List<Long>

  @Delete
  fun delete(user: User)
}