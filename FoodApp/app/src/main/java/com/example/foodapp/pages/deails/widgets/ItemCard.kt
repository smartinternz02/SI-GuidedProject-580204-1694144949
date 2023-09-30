package com.example.foodapp.pages.deails.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ItemCard(scope: CoroutineScope, snackbarHostState: SnackbarHostState,index : Int) {
    val foodItem = mapOf(
        R.drawable.hamburger to "Hamburger",
        R.drawable.birthday_cake to "Cake",
        R.drawable.french_fries to "French Fries",
        R.drawable.pizza to "Pizza",
        R.drawable.spaghetti to "Spaghetti",
        R.drawable.sandwich to "Sandwich",
    )
    OutlinedCard(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = painterResource(id = foodItem.keys.elementAt(index)),
                    contentDescription = "Food Image"
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                modifier = Modifier
                    .height(140.dp)
                    .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = foodItem.values.elementAt(index),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Medium)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Item Added to Card")
                            }
                        }
                    ) {
                        Text(text = "Add to Card", style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight.Bold))
                    }
                }
            }
        }
    }
}