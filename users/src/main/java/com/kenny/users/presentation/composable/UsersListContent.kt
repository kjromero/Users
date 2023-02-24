package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import com.kenny.users.R
import com.kenny.users.entities.data.User


@Composable
fun UsersListContent(
    usersList: List<User>,
    modifier: Modifier = Modifier,
    //onUserClick: (String) -> Unit
) {
    LazyColumn {
        itemsIndexed(
            items = usersList,
            key = { _, user -> user.id }
        ) { _, item ->
            UserItem(
                user = item,
            )
        }
    }
}
