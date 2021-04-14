package com.example.udacityprojectfinal.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.udacityprojectfinal.model.User


@Dao
interface UserDao {
//    @Query("select * from userdatabase")
//    fun getUsers() : LiveData<List<User>>

//    @Query("select * from databaseuser")
//    fun getAllUsers() : LiveData<List<User>>
}

@Database(entities = [DatabaseUser::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}


private lateinit var INSTANCE: UserDatabase

fun getDatabase(context: Context): UserDatabase {
    synchronized(DatabaseUser::class.java) {
        if(!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                UserDatabase::class.java,
                "asteroid").build()
        }
    }

    return INSTANCE
}