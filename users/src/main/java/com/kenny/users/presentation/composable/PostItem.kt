package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kenny.base.Background
import com.kenny.base.OnBackground
import com.kenny.base.Primary
import com.kenny.base.PrimaryVariant
import com.kenny.users.R
import com.kenny.users.entities.data.Post

@Composable
fun PostItem(
    post: Post,
    onBackClick: () -> Unit
){
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
                text = post.title,
                color = Primary,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.dimen_small)),
                text = post.body,
                color = OnBackground,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
            )
        }
    }
}