package com.tc.support.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.tc.support.R
import com.tc.support.data.Request
import com.tc.support.data.RequestStatus
import com.tc.support.data.RequestType
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReqestsScreen(
    modifier : Modifier = Modifier,
    requests : List<Request>,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = { 
            TopAppBar(
                title = { Text("All Requests") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            ) 
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(requests) {
                RequestItem(request = it)
            }
        }
    }
}

@Composable
fun RequestItem(
    modifier: Modifier = Modifier,
    request : Request
) {

    // defining the content
    // Theme setting EDIT HERE for dynamic theme
    var icon : Int
    var color : Color
    var backgroundColor : Color
    var status : String

    val title = when(request.type) {
        RequestType.GRIEVANCE -> "Grievance"
        RequestType.LEAVE -> "Leave Request"
        RequestType.POLICY -> "Policy Inquiry"
        RequestType.IT_SUPPORT -> "IT Ticket"
    }


    when (request.status) {
        RequestStatus.IN_REVIEW -> {

            // theme
            color = Color(0xFF8D7600)
            icon = R.drawable.ic_hourglasstop
            status = "In Review"

            backgroundColor = Color(0xFFFCF7E5)

            val iconColor = Color(0xFF8D7600)


        }
        RequestStatus.APPROVED -> {
            color = Color(0xFF0D7300)
            icon = R.drawable.ic_check
            status = "Approved"

            backgroundColor = Color(0xFFE5FAE3)
        }

        RequestStatus.CLOSED -> {
            color = Color(0xFF383838)
            icon = R.drawable.ic_doc
            status = "Closed"

            backgroundColor = Color(0xDFD3D3D3)
        }
    }
    Card(
        modifier = modifier.fillMaxWidth().padding(6.dp),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = {},
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp),

        ) {
        ConstraintLayout(Modifier.fillMaxWidth().padding(4.dp)) {

            val (iconRef, titleRef, dateRef, statusRef, arrowRef) = createRefs()


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding()
                    .size(40.dp)
                    .background(
                        color = color.copy(alpha = 0.15f),
                        shape = CircleShape
                    )
                    .constrainAs(iconRef) {
                    start.linkTo(parent.start, margin = 10.dp)
                    top.linkTo(parent.top, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "Request $status",
                    tint = color,
                    modifier = Modifier.size(25.dp)
                )
            }


            Text(
                text = "${title} #${request.id}",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.constrainAs(titleRef) {
                    start.linkTo(iconRef.end, margin = 15.dp)
                    top.linkTo(iconRef.top)
                    // bottom.linkTo(dateRef.top)
                }

            )
            Text(
                text = request.date.getBetterDate(request.status),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.constrainAs(dateRef) {
                    start.linkTo(iconRef.end, margin = 15.dp)
                    bottom.linkTo(iconRef.bottom)
                }
                )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    //.size(55.dp)
                    .background(
                        color = color.copy(alpha = 0.1f),
                    )
                    .constrainAs(statusRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(arrowRef.start, margin = 3.dp)
                    },
            ) {
                Text(
                    text = " $status ",
                    color = color,
                    modifier = Modifier.padding(2.dp),
                    fontSize = 12.sp
                )

            }

            Icon(
                painter = painterResource(R.drawable.ic_right_rrow),
                contentDescription = "Request $status",
                tint = color,
                modifier = Modifier.constrainAs(arrowRef) {
                    end.linkTo(parent.end, margin = 10.dp)
                    top.linkTo(parent.top, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
                    .size(25.dp)
            )

        }
    }
}


fun String.getBetterDate(status: RequestStatus): String {

    //  "2026-04-29T10:23:45"

    val localDateTime = LocalDateTime.parse(this)
    val postInstant = localDateTime.atZone(ZoneId.systemDefault()).toInstant()
    val now = Instant.now()

    val hours = ChronoUnit.HOURS.between(postInstant, now)
    val days = ChronoUnit.DAYS.between(postInstant, now)

    val actionText = when (status) {
        RequestStatus.IN_REVIEW -> "Submitted"
        RequestStatus.APPROVED -> "Approved"
        RequestStatus.CLOSED -> "Closed"
    }

    val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
    val monthDayFormatter = DateTimeFormatter.ofPattern("MMMM d")
    val fullDateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy")
    val zoneId = ZoneId.systemDefault()

    return when {
        // Less than 24 hours ago
        hours < 24 -> {
            val timeString = timeFormatter.format(localDateTime)
            "$actionText today, $timeString"
        }
        // Between 24 and 48 hour
        days < 2 -> {
            val timeString = timeFormatter.format(localDateTime)
            "$actionText yesterday, $timeString"
        }
        // Less than a year ago
        days < 365 -> {
            val dateString = monthDayFormatter.format(localDateTime)
            "$actionText $dateString"
        }
        // MOre  than a year
        else -> {
            val dateString = fullDateFormatter.format(localDateTime)
            "$actionText $dateString"
        }
    }
}