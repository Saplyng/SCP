package com.example.scp

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.Image
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview


@Composable
fun PictureScreen(image: Int){
    var pictureToDraw = +imageResource(image)
    DrawImage(pictureToDraw)
}