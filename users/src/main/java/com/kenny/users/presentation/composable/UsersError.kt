package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.kenny.users.R


@Composable
fun UsersError(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), // for swipe-to-refresh
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "error",//stringResource(id = R.string.rockets_error_fetching),
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
    }
}