package com.kenny.users.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kenny.users.domain.local.UsersDao
import com.kenny.users.entities.data.User
import com.kenny.users.utils.DB_NAME
import com.kenny.users.utils.DB_VERSION

@Database(entities = [User::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}

