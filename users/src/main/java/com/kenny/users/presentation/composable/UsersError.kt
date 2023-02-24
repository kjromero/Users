package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.kenny.base.Error
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
            text = stringResource(id = R.string.error_message),
            color = Error,
            textAlign = TextAlign.Center,
        )
    }
}
