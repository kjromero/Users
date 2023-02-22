package com.kenny.users.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kenny.users.entities.data.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface UsersDao {

    @Query("SELECT * FROM users")
    fun getAllUsers() : Single<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Single<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Completable
}