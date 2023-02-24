package com.kenny.users.domain.usescases

import com.kenny.core.usecase.SingleUseCase
import com.kenny.users.domain.repositories.UsersRepositoryImpl
import com.kenny.users.entities.data.Post
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPostsByUserUseCase  @Inject constructor(
    private val usersRepository: UsersRepositoryImpl
) : SingleUseCase<Int, List<@JvmSuppressWildcards Post>>() {

    override fun execute(input: Int): Single<List<Post>> {
        return usersRepository.getPosts(input)
    }
}