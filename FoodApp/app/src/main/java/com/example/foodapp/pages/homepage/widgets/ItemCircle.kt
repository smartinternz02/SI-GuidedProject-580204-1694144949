package com.example.foodapp.pages.homepage.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.R


@Composable
fun ItemCircle(index : Int) {
    val foodItem = mapOf(
        R.drawable.hamburger to "Hamburger",
        R.drawable.birthday_cake to "Cake",
        R.drawable.french_fries to "French Fries",
        R.drawable.pizza to "Pizza",
        R.drawable.spaghetti to "Spaghetti",
        R.drawable.sandwich to "Sandwich",
    )
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Box(
            modifier = Modifier
                .size(60.dp)
                .padding(2.dp)
                .clip(CircleShape)
                .border(1.dp,MaterialTheme.colorScheme.inversePrimary, CircleShape)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Image(
                painter = painterResource(id = foodItem.keys.elementAt(index)),
                contentDescription = "FoodImg"
            )
        }
        Text(text = foodItem.values.elementAt(index))
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCirclePreview() {
    ItemCircle(index = 0)
}