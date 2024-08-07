package com.rushi.jettest.di

import android.content.Context
import androidx.room.Room
import com.rushi.jettest.model.AppDatabase
import com.rushi.jettest.model.room_model.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    // Provides a singleton instance of AppDatabase
    /*
    * fallbackToDestructiveMigration is used to migration of the version of AppDatabase @Database(entities = [Post::class], version = 2)
    * */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    // Provides an instance of PostDao
    @Provides
    fun providePostDao(database: AppDatabase): PostDao {
        return database.postDao()
    }
}