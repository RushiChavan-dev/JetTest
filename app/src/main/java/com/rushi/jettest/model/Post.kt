package com.rushi.jettest.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.Provides


/*
* @Entity  define a data class as a table in the Room database.
* Each instance of the class represents a row in the table.
* */
@Entity(tableName = "post")
data class Post(

    /*
    * @PrimaryKey marks a field as the primary key of an entity/table
    * */
    @PrimaryKey val id : Int,
    val userId:Int,
    val title:String,
    val body:String
)
