package com.mun.bonecci.photopicker.utils

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build

class UriUtils {

    /**
     * Converts a URI to a Bitmap using the provided [context] and [uri].
     *
     * @param context The context used to access the content resolver.
     * @param uri The URI of the image to be converted to a Bitmap.
     * @return The Bitmap representation of the image, or null if conversion fails.
     */
    fun uriToBitmap(context: Context, uri: Uri): Bitmap? {
        // Obtain the content resolver from the context
        val contentResolver: ContentResolver = context.contentResolver

        // Check the API level to use the appropriate method for decoding the Bitmap
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            // For Android P (API level 28) and higher, use ImageDecoder to decode the Bitmap
            val source = ImageDecoder.createSource(contentResolver, uri)
            ImageDecoder.decodeBitmap(source)
        } else {
            // For versions prior to Android P, use BitmapFactory to decode the Bitmap
            val bitmap = context.contentResolver.openInputStream(uri)?.use { stream ->
                Bitmap.createBitmap(BitmapFactory.decodeStream(stream))
            }
            bitmap
        }
    }

}