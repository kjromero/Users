package com.kenny.users.usescases

import com.kenny.users.domain.repositories.UsersRepositoryImpl
import com.kenny.users.domain.usescases.GetUsersListUseCase
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
class GetUsersListUseCaseTest {

    @MockK
    private lateinit var repository: UsersRepositoryImpl

    private lateinit var subject: GetUsersListUseCase

    @BeforeEach
    fun setUp() {
        subject = GetUsersListUseCase(repository)
    }

    @Test
    fun `Should return the list of users when this is invoked`() {
        // given
        val listUsers =
            listOf(mockk<User>(), mockk<User>(), mockk<User>())

        every {
            repository.getUsers()
        } returns Single.just(listUsers)

        // when
        val testObserver = subject.execute(Unit).test()

        // then
        testObserver.assertResult(listUsers)
        testObserver.assertNoErrors()
        testObserver.assertComplete()
    }

}