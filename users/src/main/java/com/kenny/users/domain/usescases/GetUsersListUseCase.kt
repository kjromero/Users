package com.kenny.users.domain.usescases

import com.kenny.core.usecase.SingleUseCase
import com.kenny.users.domain.repositories.UsersRepositoryImpl
import com.kenny.users.entities.data.User
import com.kenny.users.entities.interfaces.UsersRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUsersListUseCase  @Inject constructor(
    private val usersRepository: UsersRepositoryImpl
) : SingleUseCase<Unit, List<@JvmSuppressWildcards User>>() {

    override fun execute(input: Unit): Single<List<User>> {
        return usersRepository.getUsers()
    }
}