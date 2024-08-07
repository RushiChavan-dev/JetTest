package com.rushi.jettest.model.room_model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rushi.jettest.model.Post
import kotlinx.coroutines.flow.Flow

/*
* @Dao Marks an interface or abstract class as a Data Access Object (DAO) in Room.
* Defines methods for interacting with the database, such as queries and data manipulation.
* */
@Dao
interface PostDao {

    @Query("Select * from post" )
    fun getAllPost(): Flow<List<Post>>

    /*
    * OnConflictStrategy
    * Purpose: Specifies what to do when there’s a conflict between new and existing data.
    * Common Strategies:
    *    + REPLACE: Replaces the old data with the new data.
    *    + IGNORE: Ignores the new data if a conflict occurs.
    * */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: List<Post>)
}