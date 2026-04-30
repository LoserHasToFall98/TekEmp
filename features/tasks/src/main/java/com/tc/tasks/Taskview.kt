package com.tc.tasks
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun TaskView(modifier: Modifier = Modifier) {

    var selectedFilter by remember { mutableStateOf("All") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Your Duties",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "3 pending tasks required attention",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("All", "Today", "Upcoming").forEach { filter ->
                FilterChip(
                    selected = selectedFilter == filter,
                    onClick = { selectedFilter = filter },
                    label = { Text(filter) }
                )
            }
        }
    }
}
//        Spacer(modifier = Modifier.height(16.dp))
//        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
//            item {
//                TaskCard(
//                    title = " Sefety Compliance",
//                    subtitle = "Assigned by HR*Priority",
//                    time = "Due 5 PM",
//                    urgent = true
//                )
//            }
//            item {
//                TaskCard(
//                    title = " Daily Report",
//                    subtitle = "Recurring*Self",
//                    time = "Today",
//                )
//            }
//            item {
//                TaskCard(
//                    title = " Monthly Review",
//                    subtitle = "Manager request",
//                    time = "Oct 30",
//                )
//            }
//        }
//    }
//}






