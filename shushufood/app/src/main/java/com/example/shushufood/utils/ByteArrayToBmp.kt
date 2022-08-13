package com.example.shushufood.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory

fun ByteArrayToBmp(byteArray: ByteArray) : Bitmap {
    return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
}