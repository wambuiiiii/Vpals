package com.joy.vpals.ui.theme.screens

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joy.vpals.R
import com.joy.vpals.ui.theme.VPalsTheme
//import com.joy.vpals.ui.theme.FeatherAndroidTasksTheme
import kotlinx.coroutines.launch

data class ImageItem(val title: String, val description: String, val image: Int)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ImageList(images: List<ImageItem>) {
    var expandedIndex by remember { mutableStateOf(-1) }
    var searchText by remember { mutableStateOf(TextFieldValue()) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Image Gallery",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(images.filter {
                it.title.contains(
                    searchText.text,
                    ignoreCase = true
                )
            }) { image ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                expandedIndex =
                                    if (expandedIndex == images.indexOf(image)) -1
                                    else images.indexOf(image)
                            }
                            .padding(16.dp)
                    ) {
                        Text(
                            text = image.title,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Show image description when expanded
                        AnimatedVisibility(
                            visible = expandedIndex == images.indexOf(image),
                            enter = expandVertically(
                                animationSpec = tween(250)
                            ),
                            exit = shrinkVertically(
                                animationSpec = tween(250)
                            ),
                            modifier = Modifier.animateContentSize()
                        ) {
                            Text(
                                text = image.description,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val images = listOf(
        ImageItem("Image 1", "Description for Image 1", R.drawable.img),
        ImageItem("Image 2", "Description for Image 2", R.drawable.img),
        ImageItem("Image 3", "Description for Image 3", R.drawable.img),
        // Add more image items here
    )

    ImageList(images)
}

@Composable
fun MyApp() {
   VPalsTheme {
        MainScreen()
    }
}

@Composable
fun App() {
    MyApp()
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    App()
}
