package com.waiyanphyo.seaauqarium.ui.composeComponents

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.waiyanphyo.seaauqarium.data.Button

@Composable
fun ButtonGrid(modifier: Modifier = Modifier, buttons: List<Button>, onButtonClick: (String) -> Unit) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(4),
    ) {
        items(buttons){ button ->
            CircleButton(iconId = button.iconId, buttonText = button.buttonText, onButtonClick = onButtonClick)
        }
    }
}