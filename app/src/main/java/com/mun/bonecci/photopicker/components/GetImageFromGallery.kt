package com.mun.bonecci.photopicker.components

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.mun.bonecci.photopicker.ui.theme.dimen_10dp
import com.mun.bonecci.photopicker.ui.theme.dimen_14dp
import com.mun.bonecci.photopicker.ui.theme.dimen_16dp
import com.mun.bonecci.photopicker.ui.theme.dimen_18dp
import com.mun.bonecci.photopicker.ui.theme.dimen_200dp
import com.mun.bonecci.photopicker.ui.theme.dimen_5dp
import com.mun.bonecci.photopicker.utils.UriUtils

/**
 * A composable function that displays an image loaded from the gallery and provides a button to select
 * an image from the gallery. Uses the PickVisualMedia activity result launcher to handle image selection.
 */
@Composable
fun GetImageFromGallery() {
    // Retrieve the current context using LocalContext.current
    val context = LocalContext.current

    // Create a remembered variable to store the loaded image bitmap
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    // Create a remembered variable to track whether an image is loaded
    var isImageLoaded by remember { mutableStateOf(false) }

    // Create an activity result launcher for picking visual media (images in this case)
    val pickMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                // Grant read URI permission to access the selected URI
                val flag = Intent.FLAG_GRANT_READ_URI_PERMISSION
                context.contentResolver.takePersistableUriPermission(uri, flag)

                // Convert the URI to a Bitmap and set it as the imageBitmap
                imageBitmap = UriUtils().uriToBitmap(context, it)?.asImageBitmap()

                // Set isImageLoaded to true
                isImageLoaded = true
            }
        }

    // Create a Card composable to wrap the image and button
    Card(
        shape = RoundedCornerShape(dimen_14dp),
        modifier = Modifier.padding(dimen_10dp, dimen_16dp, dimen_10dp, dimen_16dp),
        elevation = CardDefaults.cardElevation(defaultElevation = dimen_10dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
    ) {
        // Create a Column to arrange the image and button vertically
        Column {
            // Check if an image is loaded
            if (isImageLoaded) {
                // Display the loaded image using the Image composable
                imageBitmap?.let {
                    Image(
                        bitmap = it,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(dimen_200dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(bottomStart = dimen_18dp, bottomEnd = dimen_18dp))
                    )
                }
            }

            // Add spacing
            Spacer(modifier = Modifier.height(dimen_5dp))

            // Display a button with an icon to trigger the image selection
            TextButtonWithIcon(
                onClick = { pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) }
            )
        }
    }
}

/**
 * A composable function that creates a button with an icon for selecting an image from the gallery.
 *
 * @param onClick The lambda expression that will be invoked when the button is clicked.
 */
@Composable
fun TextButtonWithIcon(onClick: () -> Unit) {
    // Create a Button with the specified onClick lambda
    Button(
        onClick = { onClick.invoke() }
    ) {
        // Create a Row to arrange the icon and text horizontally
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Display an icon using the rememberGalleryThumbnail() function
            Icon(
                imageVector = rememberGalleryThumbnail(),
                contentDescription = "Gallery Icon"
            )
            // Add spacing between the icon and the text
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            // Display text for the button
            Text(text = "Select image from Gallery")
        }
    }
}