package com.kenny.users.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenny.base.Background
import com.kenny.base.Primary
import com.kenny.users.R
import com.kenny.users.entities.data.User
import com.kenny.users.presentation.utils.EMPTY_STRING

@Composable
fun UserItem(
    user: User,
    onPostClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_small),
                vertical = dimensionResource(id = R.dimen.dimen_small)
            ),
        backgroundColor = Background,
        elevation = dimensionResource(id = R.dimen.dimen_small_elevation)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.dimen_small),
                    vertical = dimensionResource(id = R.dimen.dimen_medium)
                ),
        ) {
            Text(
                text = user.name,
                color = Primary,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
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
            Text(
                text = stringResource(id = R.string.show_posts),
                color = Primary,
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = dimensionResource(id = R.dimen.dimen_small)
                    )
                    .clickable { onPostClick() },
            )
        }
    }
}