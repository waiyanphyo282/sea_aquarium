package com.waiyanphyo.seaauqarium.data

import androidx.annotation.DrawableRes
import java.io.Serializable

data class UpcomingShow(
    val time: String,
    val title: String,
    @DrawableRes val image: Int,
    val distance: String,
    val description: String
): Serializable