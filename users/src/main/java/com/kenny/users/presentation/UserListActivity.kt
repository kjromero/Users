package com.kenny.users.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.kenny.base.UsersTheme
import com.kenny.users.presentation.composable.UsersRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UsersTheme {
                UsersRoute()
            }
        }
    }
}