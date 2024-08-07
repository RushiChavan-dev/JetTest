package com.rushi.jettest.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rushi.jettest.model.room_model.PostDao


@Database(entities = [Post::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}