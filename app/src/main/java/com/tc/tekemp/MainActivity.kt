package com.tc.tekemp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tc.tasks.TaskView
import com.tc.tekemp.ui.theme.TekEmpTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TekEmpTheme {
                TaskView()
            }
        }
    }
}
