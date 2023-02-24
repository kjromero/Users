package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.kenny.users.R
import com.kenny.users.entities.data.User


@Composable
fun UserItem(
    user: User,
) {
    Row (
        modifier = Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.dimen_medium)
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.dimen_small)
            )
        ) {
            Text(
                text = user.name,
            )
            Text(
                text = user.email,
            )
            Text(
                text = user.phone,
            )
            Text(
                text = user.username,
            )

        }
    }
}