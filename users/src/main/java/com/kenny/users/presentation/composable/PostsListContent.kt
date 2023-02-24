package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenny.base.Primary
import com.kenny.users.R
import com.kenny.users.entities.data.Post
import com.kenny.users.entities.data.User
import com.kenny.users.presentation.utils.EMPTY_STRING

@Composable
fun PostsListContent(
    usersList: List<User>,
    postList: List<Post>,
    onBackClick: () -> Unit
) {
    val user = usersList.find { user -> user.id == usersList[0].id }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        user?.let {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.dimen_small))
            ) {
                Text(
                    text = user.name,
                    color = Primary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
                Row {
                    Icon(
                        Icons.Default.Phone,
                        contentDescription = EMPTY_STRING,
                        tint = Primary
                    )
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = user.phone,
                        fontSize = 14.sp,
                    )
                }
                Row {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = EMPTY_STRING,
                        tint = Primary
                    )
                    Text(
                        modifier = Modifier.padding(8.dp, 0.dp),
                        text = user.email,
                        fontSize = 14.sp,
                    )
                }
            }
        }
        LazyColumn {
            itemsIndexed(
                items = postList,
                key = { _, post -> post.id }
            ) { _, item ->
                PostItem(
                    post = item,
                    onBackClick = { onBackClick() }
                )
            }
        }
    }
}
