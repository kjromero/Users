package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kenny.base.OnSecondary
import com.kenny.base.Primary
import com.kenny.users.R
import com.kenny.users.presentation.UsersUiState
import com.kenny.users.presentation.UsersViewModel

@Composable
fun UsersRoute(
    viewModel: UsersViewModel = hiltViewModel()
) {
    val uiState by viewModel.data.observeAsState()

    uiState?.let {
        UsersScreen(
            uiState = it,
            onPostsClick =  { userId ->
                viewModel.getPostsByUser(userId)
            },
            onBackClick = {
                viewModel.clearPosts()
            }
        )
    }
}

@Composable
internal fun UsersScreen(
    uiState: UsersUiState,
    onPostsClick: (Int) -> Unit,
    onBackClick: () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.title))
                },
                backgroundColor = Primary,
                contentColor = OnSecondary,
                elevation = 10.dp
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Surface (
            modifier = Modifier
                .padding(it)
        ) {
            if (uiState.posts.isNotEmpty()) {
                PostsContent(
                    uiState = uiState,
                    snackbarHostState = snackbarHostState,
                    onBackClick = onBackClick
                )
            } else if (uiState.users.isNotEmpty()) {
                UsersListContent(
                    uiState = uiState,
                    snackbarHostState = snackbarHostState,
                    onPostsClick = onPostsClick
                )
            } else {
                UsersNotContent(
                    uiState = uiState
                )
            }
        }
    }
}

@Composable
private fun UsersListContent(
    uiState: UsersUiState,
    snackbarHostState: SnackbarHostState,
    onPostsClick: (Int) -> Unit
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.error_message)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage
            )
        }
    }

    UsersListContent(
        usersList = uiState.users,
        onPostsClick = { onPostsClick(it) }
    )
}

@Composable
private fun PostsContent(
    uiState: UsersUiState,
    snackbarHostState: SnackbarHostState,
    onBackClick: () -> Unit
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.error_message)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage
            )
        }
    }

    PostsListContent(
        usersList = uiState.users,
        postList = uiState.posts,
        onBackClick = { onBackClick() }
    )
}

@Composable
private fun UsersNotContent(uiState: UsersUiState) {
    when {
        uiState.isLoading -> UsersLoader()
        uiState.isError -> UsersError()
    }
}