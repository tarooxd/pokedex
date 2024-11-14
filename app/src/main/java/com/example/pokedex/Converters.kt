//---**DEPRECATED**---//


//package com.example.pokedex
//
//import android.content.Context
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import androidx.room.TypeConverter
//import java.io.ByteArrayOutputStream
//
//class Converters (){
//
//    @TypeConverter
//    fun convertBitmapToByteArray(bitmap: Bitmap): ByteArray{
//        val outputStream = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
//        return outputStream.toByteArray()
//    }
//
//    @TypeConverter
//    fun convertByteArrayToBitmap(byteArray: ByteArray) =
//        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//}