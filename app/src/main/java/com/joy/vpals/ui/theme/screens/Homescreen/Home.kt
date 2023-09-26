package com.joy.vpals.ui.theme.screens.Homescreen



import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.joy.vpals.R
import com.joy.vpals.navigation.ROUTE_FORM
import kotlinx.coroutines.launch


@Composable
fun HomeScreen (navController: NavHostController){

    val expanded= remember { mutableStateOf(false) }
    val extrapadding by animateDpAsState(
        if (expanded.value)24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    var searchText by remember { mutableStateOf(TextFieldValue()) }


    val imageList = listOf(
        R.drawable.img_6,
        R.drawable.img_4,
        R.drawable.img_2
    )
    val instagramUrls = listOf(
        "https://www.instagram.com/redcrosske/",
        "https://www.instagram.com/amrefhealthafrica/",
        "https://www.instagram.com/your_instagram_url_3/"
    )
    val twitterUrls = listOf(
        "https://twitter.com/KenyaRedCross?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor",
        "https://twitter.com/Amref_Worldwide",
        "https://www.instagram.com/your_instagram_url_3/"
    )
    val textList = listOf(
       "A leading humanitarian organization sustainably promoting the well-being, health and resilience of communities in Kenya. We are #AlwaysThere.\n\nContact us via:"
        ,
        "A leading humanitarian organization sustainably promoting the well-being, health and resilience of communities in Kenya.\n We are #AlwaysThere.\n \nContact us via:"

        ,
        "Text for Image 3"
    )
    val coroutineScope = rememberCoroutineScope()
    val context= LocalContext.current
    val expandedStates = remember { // Maintain separate states for each item
        imageList.map { mutableStateOf(false) }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = "Image Gallery",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Tell us more about yourself",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

//        Spacer(modifier = Modifier.height(16.dp))
//
//        BasicTextField(
//            value = searchText,
//            onValueChange = { searchText = it },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

            items(imageList.size) { index ->

                val imageRes = imageList[index]
                val expanded = expandedStates[index].value



//            Surface(
//                color = MaterialTheme.colorScheme.primary,
//                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//            ) {

                Column(
                    modifier = Modifier



                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .size(400.dp)
                            .clickable { navController.navigate(ROUTE_FORM) }
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                }
                OutlinedButton(onClick = {expandedStates[index].value =!expanded }) {
                    Text(if (expanded) "Show less" else "Show more")

                }

                if (expanded) {

                    Column(
                        modifier = Modifier.padding(
                            bottom = extrapadding.coerceAtLeast(0.dp)
                        )
                    ) {
                        Text(text = textList[index])
                        val openTwitter = true
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            // Twitter icon with a clickable modifier
                            Image(
                                painter = painterResource(id = R.drawable.img_8),
                                contentDescription = "Twitter Icon",
                                modifier = Modifier
                                    .size(20.dp) // Adjust the size as needed
                                    .clickable {
                                        val twitterUrl = twitterUrls[index]
                                        val twitterIntent = Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl))
                                        coroutineScope.launch {
                                            context.startActivity(twitterIntent)
                                        }
                                    }
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            // Instagram icon with a clickable modifier
                            Image(
                                painter = painterResource(id = R.drawable.img_7),
                                contentDescription = "Instagram Icon",
                                modifier = Modifier
                                    .size(20.dp) // Adjust the size as needed
                                    .clickable {
                                        val instagramUrl = instagramUrls[index]
                                        val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
                                        coroutineScope.launch {
                                            context.startActivity(instagramIntent)
                                        }
                                    }
                            )
                        }
//                        Row(
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier.clickable {
//                                val instagramUrl = instagramUrls[index]
//                                val twitterUrl = twitterUrls[index]
//
//                                // Handle the click event, you can open Twitter or Instagram based on user preference.
//
//                                // For Twitter
//                                val twitterIntent = Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl))
//
//                                // For Instagram
//                                val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
//
//                                // Use the coroutineScope to launch the intent
//                                coroutineScope.launch {
//                                    context.startActivity(if (openTwitter) twitterIntent else instagramIntent)
//                                }
//                            }
//                        ) {
//                            // Twitter icon
//                            Image(
//                                painter = painterResource(id = R.drawable.img_8),
//                                contentDescription = "Twitter Icon",
//                                modifier = Modifier.size(30.dp) // Adjust the size as needed
//                            )
//                            Spacer(modifier = Modifier.width(10.dp))
//
//                            // Instagram icon
//                            Image(
//                                painter = painterResource(id = R.drawable.img_7),
//                                contentDescription = "Instagram Icon",
//                                modifier = Modifier.size(30.dp) // Adjust the size as needed
//                            )
//                        }


//
//                        Row(
//
//                            modifier = Modifier.clickable {
//                                val instagramUrl = instagramUrls[index]
//                                val twitterUrl = twitterUrls[index]
//
////                                val instagramUsername = "username" // Replace with the actual Instagram username
//
//                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
////                                val context = LocalContext.current
//
//                                // Use the coroutineScope to launch the intent
//                                coroutineScope.launch {
//                                    context.startActivity(intent)
//                                }
//
//                                // Handle the click to navigate to the Instagram page
//                                // Replace 'your_instagram_url' with the actual URL
////                                val instagramUrl = "https://www.instagram.com/your_instagram_url/"
//
//                            }
//                        ) {
//                            val customInstagramIcon = painterResource(R.drawable.img_3) // Replace with your custom icon resource
//
//                            Icon(
//                                painter = customInstagramIcon,
//                                contentDescription = "Instagram Icon"
//                               // You can customize the icon color
//                            )
//
////                            Text(
////                                text = "Follow us on Instagram", // Replace with your text
////                                modifier = Modifier.padding(start = 8.dp)
////                            )
                    }
                }

            }
        }


    }}




