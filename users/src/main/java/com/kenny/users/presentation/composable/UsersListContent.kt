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

const val USER_DIVIDER_TEST_TAG = "rUSERDividerTestTag"

@Composable
fun UsersListContent(
    usersList: List<User>,
    modifier: Modifier = Modifier,
    //onUserClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_medium)
            )
    ) {
        itemsIndexed(
            items = usersList,
            key = { _, user -> user.id }
        ) { index, item ->
            UserItem(
                user = item,
            )

            if (index < usersList.lastIndex) {
                Divider(
                    modifier = Modifier.testTag(USER_DIVIDER_TEST_TAG)
                )
            }
        }
    }
}
