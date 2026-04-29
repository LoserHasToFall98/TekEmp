package com.tc.theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SampleComposable(modifier: Modifier = Modifier){
    Column(modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Daily Report",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {}) {
            Text("Start Update")
        }
    }
}
