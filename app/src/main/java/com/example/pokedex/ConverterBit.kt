//---**DEPRECATED**---//


//package com.example.pokedex
//
//import android.content.Context
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import java.io.ByteArrayOutputStream
//import java.io.File
//import java.io.FileOutputStream
//import java.io.IOException
//
//
//class ConverterBit(
//    private val context: Context
//) {
//    fun convertBitmapToByteArrayFromDrawable(id: Int): ByteArray {
//        val bitmap = BitmapFactory.decodeResource(context.resources, id)
//
//        val outputStream = ByteArrayOutputStream()
//
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
//        return outputStream.toByteArray()
//    }
//
//    fun getBitMap(id: Int): Bitmap {
//        return BitmapFactory.decodeResource(context.resources, id)
//    }
//
//    fun saveBitmap(bitmap: Bitmap, filename: String): String? {
//
//        val directory = File(context.cacheDir, "images")
//        if (!directory.exists()) {
//            directory.mkdirs()
//        }
//
//        val file = File(directory, "$filename.png")
//
//        var fileOutputStream: FileOutputStream? = null
//        return try {
//            fileOutputStream = FileOutputStream(file)
//
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
//
//            file.absolutePath
//        } catch (e: IOException) {
//            e.printStackTrace()
//            null
//        } finally {
//            fileOutputStream?.close()
//        }
//    }
//
//}
//
