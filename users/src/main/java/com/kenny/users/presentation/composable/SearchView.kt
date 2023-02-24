package com.kenny.users.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenny.base.OnBackground
import com.kenny.base.Primary
import com.kenny.base.Surface
import com.kenny.users.R
import com.kenny.users.presentation.utils.EMPTY_STRING

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    Column(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_medium),
                vertical = dimensionResource(id = R.dimen.dimen_small)
            )
    ) {
        Text(
            text = stringResource(id = R.string.search_user),
            fontSize = 12.sp,
            color = Primary
        )
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(color = OnBackground, fontSize = 14.sp),
            trailingIcon = {
                if (state.value != TextFieldValue(EMPTY_STRING)) {
                    IconButton(
                        onClick = {
                            state.value = TextFieldValue(EMPTY_STRING)
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = EMPTY_STRING,
                            modifier = Modifier
                                .padding(15.dp)
                                .size(24.dp)
                        )
                    }
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = OnBackground,
                cursorColor = Primary,
                backgroundColor = Surface,
            )
        )
    }
}