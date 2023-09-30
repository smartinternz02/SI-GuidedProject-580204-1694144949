package com.example.foodapp.pages.homepage.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp.R
import com.example.foodapp.navigation.Screen

@Composable
fun RestaurantCard(
    index: Int,
    navController: NavController
) {
    val restaurantDetails = mapOf(
        R.drawable.bakery_shop to "Dusle",
        R.drawable.mcd to "McBonalds",
        R.drawable.pizza_shop to "Bominoe's",
        R.drawable.sandwich_shop to "Subgay",
    )
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                navController.navigate(Screen.DetailScreen.route)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 15.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(15.dp)),
            ) {
                Image(
                    painter = painterResource(id = restaurantDetails.keys.elementAt(index)),
                    contentDescription = "Restaurant Pic",
                    contentScale = ContentScale.FillBounds
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = restaurantDetails.values.elementAt(index),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Ratings : ", style = TextStyle(fontWeight = FontWeight.Medium))
                    Spacer(modifier = Modifier.width(5.dp))
                    LazyRow {
                        items(count = 5) {
                            if (it <= 2) {
                                Icon(
                                    Icons.Filled.Star,
                                    contentDescription = "Rating Bar",
                                    tint = Color(0xffffbf00)
                                )
                            } else {
                                Icon(
                                    Icons.Outlined.Star,
                                    contentDescription = "Rating Bar",
                                    tint = Color.Gray
                                )
                            }
                        }
                    }
                }
                Text(text = "Address : 123/45 Preet Vihar, Delhi")
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text(
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.DetailScreen.route)
                        },
                        text = "More",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun RestaurantCardPreview() {
//    RestaurantCard(1)
//}