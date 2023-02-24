package com.kenny.users.usescases

import com.kenny.users.domain.repositories.UsersRepositoryImpl
import com.kenny.users.domain.usescases.GetPostsByUserUseCase
import com.kenny.users.entities.data.Post
import com.kenny.users.entities.data.User
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetPostsByUserUseCaseTest {

    @MockK
    private lateinit var repository: UsersRepositoryImpl

    private lateinit var subject: GetPostsByUserUseCase

    @BeforeEach
    fun setUp() {
        subject = GetPostsByUserUseCase(repository)
    }

    @Test
    fun `Should return the list of posts when this is invoked`() {
        // given
        val userId = 1
        val listPosts =
            listOf(mockk<Post>(), mockk<Post>(), mockk<Post>())

        every {
            repository.getPosts(userId)
        } returns Single.just(listPosts)

        // when
        val testObserver = subject.execute(userId).test()

        // then
        testObserver.assertResult(listPosts)
        testObserver.assertNoErrors()
        testObserver.assertComplete()
    }

}