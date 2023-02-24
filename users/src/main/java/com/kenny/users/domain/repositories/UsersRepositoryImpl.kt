package com.kenny.users.domain.repositories

import com.kenny.users.domain.local.UsersDao
import com.kenny.users.domain.services.UsersService
import com.kenny.users.domain.services.model.UserResponse
import com.kenny.users.entities.data.User
import com.kenny.users.entities.interfaces.UsersRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersService: UsersService,
    private val usersDao: UsersDao
): UsersRepository {

    private val usersListSubject = BehaviorSubject.create<List<User>>()
    init {
        var users = usersDao.getAllUsers()
        if (users.isEmpty()) {
            users = getUsersFromRepo()
            saveUsersOnLocal(users)
        }
        usersListSubject.onNext(users)
    }
    private fun getUsersFromRepo(): List<User> {
        return usersService.getRepositories().map { it.toBaseModel() }
    }

    private  fun saveUsersOnLocal(users: List<User>){
        usersDao.insertAll(users)
    }

    override fun getUsers(): Single<List<User>> {
        return usersListSubject.hide().firstOrError()
    }

    private fun  UserResponse.toBaseModel(): User {
        return User(
            id = id,
            name = name,
            username = username,
            email = email,
          /*  address = Address(
                street = address.street,
                suite = address.suite,
                city = address.city,
            ),*/
            phone = phone,
        )
    }
}