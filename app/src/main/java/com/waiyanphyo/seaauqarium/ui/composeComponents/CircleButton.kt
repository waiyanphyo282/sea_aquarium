package com.waiyanphyo.seaauqarium.ui.composeComponents

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waiyanphyo.seaauqarium.R
import com.waiyanphyo.seaauqarium.data.Button
import com.waiyanphyo.seaauqarium.ui.home.HomeFragment

@Composable
fun CircleButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    buttonText: String,
    onButtonClick: (String) -> Unit) {
    Column(
        modifier = modifier.padding(vertical = 8.dp)
            .clickable { onButtonClick.invoke(buttonText) },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier
                .padding(16.dp)
                .size(32.dp)
                .drawBehind {
                    drawCircle(
                        color = Color(0xfff5f5f5),
                        radius = this.size.maxDimension,
                    )
                },
            painter  = painterResource(id = iconId),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Text(text = buttonText, modifier = modifier.padding(top = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CircleButtonPreview() {
    val buttons = listOf(
        Button(R.drawable.ic_map, "Map"),
        Button(R.drawable.ic_inhabitants, "Inhabitants"),
        Button(R.drawable.ic_shows, "Shows"),
        Button(R.drawable.ic_shopping, "Shopping"),
        Button(R.drawable.ic_dines, "Dine"),
        Button(R.drawable.ic_meet_and_greets, "Meet & Greets"),
    )
    ButtonGrid(modifier = Modifier.fillMaxWidth(), buttons = buttons) {}
}