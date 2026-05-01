package com.tc.dashboard

import android.R.attr.start
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tc.theme.R


@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        //    modifier = Modifier.verticalScroll(scrollState)
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        Spacer(Modifier.height(10.dp))
        Card(
            modifier.fillMaxWidth(),
        ) {
            Column(
                modifier
                    .background(Color(0xffEDE8D0))
                    .fillMaxSize()
                    .padding(25.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(175.dp), // Space between
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 70.dp, height = 60.dp)
                            .offset(x = 2.dp, y = (0).dp) // Move shape relative to center
                            .size(60.dp) // Set your desired size here
                            .background(Color.White, shape = CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(id = com.tc.dashboard.R.drawable.person_icon),
                            contentDescription = "Person",
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(width = 80.dp, height = 50.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .offset(x = 10.dp, y = (5).dp) // Move shape relative to center
                            .size(60.dp) // Set your desired size here
                            .background(Color.White, shape = CircleShape)
                    ) {
                        Icon(
                            painter = painterResource(id = com.tc.dashboard.R.drawable.black_bell_icon),
                            contentDescription = "Notification",
                            tint = Color.Black, // This fills the entire icon with red
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(width = 60.dp, height = 30.dp)
                        )
                    }
                }
                Spacer(Modifier.height(20.dp)) // COME BACK TO SET IT BACK TO 20.dp
                Row(
                    horizontalArrangement = Arrangement.spacedBy(170.dp), // Space between
                ) {
                    Text(
                        text = "Good Morning,",
                        modifier = Modifier
                            .padding(vertical = 2.dp, horizontal = 5.dp),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )
                } // END OF ROW
                Row(
                ) {
                    Text(
                        text = "Alex.",
                        modifier = Modifier
                            .padding(vertical = 1.dp, horizontal = 5.dp),
                    fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff2E8B57)
                    )
                } // END OF ROW
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier
                        .size(width = 150.dp, height = 40.dp)
                        .background(
                            color = Color(0xfff3fcff),
                            shape = RoundedCornerShape(25.dp)
                        ) // Curvature amount
                        .padding(3.dp)
                        .offset(x = -4.dp, y = (5).dp), // Move shape relative to center
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = com.tc.dashboard.R.drawable.calendar_icon),
                        contentDescription = "Calendar",
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .padding(bottom = 10.dp)
                            .size(20.dp) // Set your desired size here
                            .background(Color.LightGray, shape = CircleShape)
                    )
                    Spacer(Modifier.width(7.dp))
                    Text(
                        text = "Tues, Oct 24",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                    )
                } // END OF ROW
                Column(
                    Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(25.dp),
                        )
                        .fillMaxSize()
                ) {
                    Row(
                        modifier
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.spacedBy(50.dp), // Space between
                    ) {
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .offset(x = 15.dp, y = -10.dp) // Move both together
                                .background(Color(0xfff7fcf5), shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(painter = painterResource(
                                id = com.tc.dashboard.R.drawable.very_sunny_icon),
                                contentDescription = "Very Sunny",
                                tint = Color(0xff2E8B57)
                            )
                        }
                        Box(
                            modifier = Modifier
//                                .size(60.dp)
                                .offset(x = 50.dp, y = -8.dp) // Move both together
                                .background(Color(0xffFFEBEE), shape = RoundedCornerShape(55.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "DUE SOON",
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .size(width = 120.dp, height = 30.dp)
                                    .padding(vertical = 3.dp, horizontal = 23.dp)
                            )
                        }
                    } // END OF ROW
                    Row() {
                        Text(
                            text = "Daily Report",
                            fontWeight = FontWeight.Bold,
                            fontSize = 27.sp,
                            modifier = Modifier
                                .padding(start = 18.dp)
                                .padding(top = 20.dp)
                        )
                    } // END OF ROW
                    Spacer(modifier.height(5.dp))

                    Row() {
                        Text(
                            text = "Your 5 PM update is waiting.",
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(start = 17.dp)
                        )
                    } // END OF ROW
                    Row(
                        modifier
                            .size(width = 190.dp, height = 40.dp)
                            .padding(3.dp)
                            .offset(x = -5.dp, y = (-5).dp), // Move shape relative to center
//                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = com.tc.dashboard.R.drawable.clock_icon),
                            contentDescription = "Clock",
                            modifier = Modifier
                                .padding(start = 25.dp)
                                .padding(top = 15.dp)
                                .size(20.dp) // Set your desired size here
                                .background(Color.LightGray, shape = CircleShape)
                        )
                        Text(
                            text = "Due in 1h 45m",
                            modifier
                                .offset(x = 5.dp, y = -2.dp) // Move both together
                                .padding(start = 5.dp)
                                .padding(top = 15.dp)
                        )

                    } // END OF ROW
                    Spacer(Modifier.height(30.dp))
                    Row(
                        Modifier
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { /* Handle click */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff2E8B57) // Sets the background color
                            ),
                            modifier = Modifier
                        ) {
                            Text(modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
                                text = "Start Update          ",
                                color = Color.White,
                                fontSize = 20.sp,
                            )
                            Icon(
                                painter = painterResource(id = com.tc.dashboard.R.drawable.right_arrow_icon),
                                contentDescription = "Right Arrow")
                        } // END OF ROW
                    } // END OF ROW
                } // END OF COLUMN
                Column(
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(23.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .size(width = 140.dp, height = 100.dp)
                                .padding(vertical = 0.dp, horizontal = 0.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(25.dp)
                                ) // Curvature amount
                        ) {
                            Box(
                                Modifier.fillMaxSize()
                                    .background(Color.White),
                                contentAlignment = Alignment.TopStart) {
                                Icon(
                                    painter = painterResource(id = com.tc.dashboard.R.drawable.check_icon),
                                    contentDescription = "Check Mark",
                                    Modifier.padding(11.dp)// Move shape relative to center
                                )
                                Text(
                                    text = "12",
                                    modifier
                                        .padding(top = 40.dp)
                                        .padding(start = 12.dp),
                                    fontSize = 20.sp,           // Setting Font Size
                                    fontWeight = FontWeight.Bold // Setting Font Weight
                                )
                                Text(
                                    text = "DONE THIS WEEK",
                                    modifier
                                        .padding(top = 70.dp)
                                        .padding(start = 15.dp),
                                    fontSize = 12.sp,           // Setting Font Size
                                    fontWeight = FontWeight.Bold // Setting Font Weight
                                )
                            }
                        }
                        Card(
                            Modifier
                                .size(width = 145.dp, height = 100.dp)
                                .background(
                                    color = Color(0xffFFFFFF00),
                                    shape = RoundedCornerShape(25.dp)
                                ) // Curvature amount
                        ) {
                            Box(
                                Modifier.fillMaxSize()
                                    .background(Color.White)
                                , contentAlignment = Alignment.TopStart) {
                            Icon(
                                painter = painterResource(id = com.tc.dashboard.R.drawable.graph_arrow_icton),
                                contentDescription = "Statistic Arrow",
                                Modifier.padding(13.dp)// Move shape relative to center
                                )
                                Text(
                                    text = "98%",
                                    modifier
                                        .padding(top = 37.dp)
                                        .padding(start = 13.dp),
                                    fontSize = 25.sp,           // Setting Font Size
                                    fontWeight = FontWeight.Bold // Setting Font Weight
                                )
                                Text(
                                    text = "ON TIME",
                                    modifier
                                        .padding(top = 70.dp)
                                        .padding(start = 15.dp),
                                    fontSize = 12.sp,           // Setting Font Size
                                    fontWeight = FontWeight.Bold // Setting Font Weight
                                )
                            }
                        }
                    } // END OF ROW
                } // END OF COLUMN
            } // END OF COLUMN
        } // END OF CARD
    }
}