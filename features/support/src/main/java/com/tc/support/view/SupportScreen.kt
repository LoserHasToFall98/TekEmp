package com.tc.support.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil3.compose.AsyncImage
import com.tc.support.data.Request
import com.tc.support.data.RequestStatus
import com.tc.support.data.RequestType

@Composable
fun SupportScreen(
    modifier : Modifier = Modifier,
    requests : List<Request>,
    onViewAllClick: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        SupportHeader()   // Section 1: Title & Profile
        ActionGrid(onClick = { type -> // Section 2: The 4 Grid Cards
                when(type) {
                    RequestType.GRIEVANCE -> Log.d("ACTION_GRID_TEST", "Grievance reported")
                    RequestType.LEAVE -> Log.d("ACTION_GRID_TEST", "Leave requested")
                    RequestType.POLICY -> Log.d("ACTION_GRID_TEST", "Policy Question")
                    RequestType.IT_SUPPORT -> Log.d("ACTION_GRID_TEST", "IT Support requested")
                }
            })

        RecentActivityHeader(onViewAllClick) // Section 3: "Recent Activity" + "View All"

        if (requests.isNotEmpty()) {
            requests.take(3).forEach { request ->
                RequestItem(request = request)
            }
        }

    }
}


@Composable
fun SupportHeader() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (titleRef, greetingRef, greetingBodyRef, pfpRef) = createRefs()

        Text(
            "SUPPORT CENTER",
            modifier = Modifier.constrainAs(titleRef) {
                start.linkTo(parent.start, margin = 10.dp)
                top.linkTo(parent.top, margin = 20.dp)
            },
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color.Green
        ) // title

        AsyncImage(
            // EDIT HERE with real user avatar before pushing
            model = "https://www.shutterstock.com/image-vector/black-woman-smiling-portrait-vector-600nw-2281497689.jpg",
            contentDescription = null,
            placeholder = ColorPainter(Color.Gray),
            error = ColorPainter(Color.Red),
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .constrainAs(pfpRef) {
                        end.linkTo(parent.end, margin = 20.dp)
                        top.linkTo(titleRef.top)
                        bottom.linkTo(titleRef.bottom)
                    }
        )// avatar

        Text(
            text = "How can we help?",
            modifier = Modifier.constrainAs(greetingRef) {
                start.linkTo(parent.start, margin = 10.dp)
                top.linkTo(titleRef.bottom, margin = 15.dp)
            },
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        ) // Greeting

        Text(
            "Manage your administrative requests and grievances in one place.",
            modifier = Modifier.constrainAs(greetingBodyRef) {
                start.linkTo(titleRef.start)
                //end.linkTo(parent.end, margin = 20.dp)
                top.linkTo(greetingRef.bottom, margin = 15.dp)

            },
            style = MaterialTheme.typography.labelMedium,
        ) // Greeting Body
    }
}



@Composable
fun ActionGrid(
    modifier: Modifier = Modifier,
    onClick: (RequestType) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .height(350.dp)// .width(400.dp)
    ) {
        val (grievanceBtn, leaveBtn, policyBtn, itSupportBtn) = createRefs()
        val defaultMargins = 20.dp

        val verticalCenter = createGuidelineFromStart(0.5f)
        val horizontalCenter = createGuidelineFromTop(0.5f)

        ActionCard(
            title = "Raise Grievance",
            icon = Icons.Default.Warning, // EDIT HERE to replace icon and colors with actual later
            backgroundColor = Color(0xFFF1FCF2),
            iconColor = Color(0xFF4CAF50),
            onClick = { onClick(RequestType.GRIEVANCE) },
            modifier = Modifier.constrainAs(grievanceBtn) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(verticalCenter)
                bottom.linkTo(horizontalCenter)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )

        ActionCard(
            title = "Request Leave",
            icon = Icons.AutoMirrored.Filled.ExitToApp, // EDIT HERE to replace icon with actual later
            backgroundColor = Color(0xFFFAF5ED),
            iconColor = Color(0xFFFF9800),
            onClick = { onClick(RequestType.LEAVE) },
            modifier = Modifier.constrainAs(leaveBtn) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(verticalCenter)
                bottom.linkTo(horizontalCenter)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )

        ActionCard(
            title = "Policy Question",
            icon = Icons.Default.Info, // EDIT HERE to replace icon with actual later
            backgroundColor = Color(0xFFEFF5FA),
            iconColor = Color(0xFF2196F3),
            onClick = { onClick(RequestType.POLICY) },
            modifier = Modifier.constrainAs(policyBtn) {
                start.linkTo(parent.start)
                end.linkTo(verticalCenter)
                top.linkTo(horizontalCenter)
                bottom.linkTo(parent.bottom)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )

        ActionCard(
            title = "IT Support",
            icon = Icons.Default.Build, // EDIT HERE to replace icon with actual later
            backgroundColor = Color(0xFFF8EEFA),
            iconColor = Color(0xFF9C27B0),
            onClick = { onClick(RequestType.IT_SUPPORT) },
            modifier = Modifier.constrainAs(itSupportBtn) {
                top.linkTo(horizontalCenter)
                end.linkTo(parent.end)
                start.linkTo(verticalCenter)
                bottom.linkTo(parent.bottom)
                // bottom.linkTo(horizontalCenter)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )

    }
}


@Composable
fun RecentActivityHeader(
    viewAll : () -> Unit
) {

    ConstraintLayout(Modifier.fillMaxWidth()) {

        val (text1Ref, text2Ref) = createRefs()
        Text(
            text = "Recent Activity",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.constrainAs(text1Ref) {
                start.linkTo(parent.start, margin = 20.dp)
                top.linkTo(parent.top)
            }

        )

        Text(
            text = "View All",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Green,
            modifier = Modifier.constrainAs(text2Ref) {
                end.linkTo(parent.end, margin = 20.dp)
                top.linkTo(parent.top)
            }
                .clickable(onClick = viewAll)

        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionCard(
    title: String,
    icon: ImageVector,
    iconColor: Color,
    backgroundColor : Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            // hoveredElevation = 8.dp
        ),
        onClick = onClick,
        modifier = modifier.aspectRatio(1f)
            .padding(12.dp), // Square card
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(25.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(55.dp)
                    .background(
                        color = iconColor.copy(alpha = 0.15f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    tint = iconColor,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp))

            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = title, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SupportScreenPreview() {
    val list = listOf(
        Request("402", RequestType.GRIEVANCE, "2026-04-29T10:23:45", RequestStatus.IN_REVIEW),
        Request("399", RequestType.LEAVE, "2026-04-22T14:15:02", RequestStatus.APPROVED),
        Request("385", RequestType.POLICY, "2026-04-18T09:05:30", RequestStatus.CLOSED),
        Request("382", RequestType.IT_SUPPORT, "2026-04-15T16:45:12", RequestStatus.APPROVED),
    ).sortedByDescending { it.date }

    SupportScreen(requests = list, onViewAllClick = {})
}