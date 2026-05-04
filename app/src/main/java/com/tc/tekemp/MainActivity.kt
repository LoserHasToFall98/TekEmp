package com.tc.tekemp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.firebase.messaging.FirebaseMessaging
import com.tc.dashboard.DashboardItem
import com.tc.dashboard.DashboardRepository
import com.tc.dashboard.DashboardScreen
import com.tc.dashboard.DashboardViewModel
import com.tc.tekemp.ui.theme.TekEmpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dashboardViewModel by viewModels<DashboardViewModel>(
                factoryProducer = {
                    object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return DashboardViewModel(DashboardRepository()) as T
                        }
                    }
                }
            )

            val dashboards by dashboardViewModel.dashboards.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
//                        viewModel.handleIntent(CounterIntent.Increment)
//                recipesViewModel.handleRecipesIntent(RecipesIntent.Recipes)
                dashboardViewModel.getDashboard()
//
            }
            Log.d("MAIN", "${dashboards}")
            DashboardScreen(
                modifier = Modifier.fillMaxSize(),
                dashboards = dashboards,
            ) {
//                dashboardViewModel.getDashboard()
            }
        }

//        FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
//            Log.d("MAIN_ACT", token)
//        }
    }
}
