package com.mindpulse.app

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun MindPulseLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = "Mind Pulse logo",
        modifier = modifier,
        contentScale = ContentScale.Fit,
    )
}

@Composable
fun MindPulseBandImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.band),
        contentDescription = "Mind Pulse band",
        modifier = modifier,
        contentScale = ContentScale.Fit,
    )
}
