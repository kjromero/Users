package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.kenny.users.entities.data.User


@Composable
fun UsersListContent(
    usersList: List<User>,
    onPostsClick: (Int) -> Unit
) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column( 
        modifier = Modifier.fillMaxSize()
    ) {
        SearchView(state = textState)
        LazyColumn {
            itemsIndexed(
                items = usersList.filter { user -> user.name.lowercase().contains(textState.value.text.lowercase()) },
                key = { _, user -> user.id }
            ) { _, item ->
                UserItem(
                    user = item,
                    onPostClick = { onPostsClick(item.id) }
                )
            }
        }
    }
}
