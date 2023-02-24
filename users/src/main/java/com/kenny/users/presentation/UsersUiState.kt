package com.kenny.users.presentation

import com.kenny.users.entities.data.User

data class UsersUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val isError: Boolean = false,
)
