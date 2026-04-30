package com.tc.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val PROFILE_ROUTE = "profile"

fun NavGraphBuilder.profileScreen(
    onEditClick: () -> Unit = {}
) {
    composable(route = PROFILE_ROUTE) {
        ProfileScreen(
            viewModel = ProfileViewModel(),
            onEditClick = onEditClick
        )
    }
}