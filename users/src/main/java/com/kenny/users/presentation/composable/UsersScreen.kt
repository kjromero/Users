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
        )
    }
}

@Composable
internal fun UsersScreen(
    uiState: UsersUiState,
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
            if (uiState.users.isNotEmpty()) {
                UsersListContent(
                    uiState = uiState,
                    snackbarHostState = snackbarHostState,
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
) {
    if (uiState.isError) {
        val errorMessage = "error"//stringResource(R.string.rockets_error_refreshing)

        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorMessage
            )
        }
    }

    UsersListContent(
        usersList = uiState.users,
        //onRocketClick = { onRocketClick(it) }
    )
}

@Composable
private fun UsersNotContent(uiState: UsersUiState) {
    when {
        uiState.isLoading -> UsersLoader()
        uiState.isError -> UsersError()
    }
}