package com.tc.tekemp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tc.profile.ProfileScreen
import com.tc.profile.ProfileViewModel
import com.tc.tekemp.ui.theme.TekEmpTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TekEmpTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "profile"
    ) {

        composable("profile") {
            val viewModel: ProfileViewModel = viewModel()

            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                ProfileScreen(
                    modifier = Modifier.padding(innerPadding),
                    viewModel = viewModel,
                    onEditClick = {
                        navController.navigate("edit_profile")
                    }
                )
            }
        }

        composable("edit_profile") {
            EditProfileScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun EditProfileScreen(onBackClick: () -> Boolean) {

}