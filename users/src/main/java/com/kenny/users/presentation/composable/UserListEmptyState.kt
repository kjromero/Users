package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.kenny.users.R

@Composable
fun UserListEmptyState() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = stringResource(id = R.string.empty_state),
            textAlign = TextAlign.Center
        )
    }
}