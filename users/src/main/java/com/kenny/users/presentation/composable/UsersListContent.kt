package com.kenny.users.presentation.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.kenny.users.entities.data.User


@Composable
fun UsersListContent(
    usersList: List<User>,
    onPostsClick: (Int) -> Unit
) {
    LazyColumn {
        itemsIndexed(
            items = usersList,
            key = { _, user -> user.id }
        ) { _, item ->
            UserItem(
                user = item,
                onPostClick = { onPostsClick(item.id) }
            )
        }
    }
}
