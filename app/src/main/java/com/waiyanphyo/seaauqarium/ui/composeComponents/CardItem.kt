package com.waiyanphyo.seaauqarium.ui.composeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.waiyanphyo.seaauqarium.R

@Composable
fun CardItem(title: String, icon: Int, content: String, action: String) {
    Card {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = title)
                Image(painter = painterResource(id = icon), contentDescription = "")
            }
            Text(text = content, style = TextStyle(fontSize = 18.sp))
            Text(text = action, style = TextStyle(color = Color(0xaaaa0000)))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    CardItem(title = "My e-tickets", icon = R.drawable.ic_ticket, content = "There aren't any yet", action = "Retrieve here")
}