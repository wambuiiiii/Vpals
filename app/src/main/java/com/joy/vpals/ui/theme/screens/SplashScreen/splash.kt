package com.joy.vpals.ui.theme.screens.SplashScreen

import android.content.res.Configuration
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.joy.vpals.navigation.ROUTE_LOGIN
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.text.style.TextForegroundStyle.Unspecified.alpha

import com.joy.vpals.R



//    @Composable
//    fun SplashScreen(navController: NavHostController) {
//        var startAnimation by remember { mutableStateOf(false) }
//
//        val alphaAnimation = animateFloatAsState(
//            targetValue = if (startAnimation) 1f else 0f,
//            animationSpec = tween(
//                durationMillis = 2000
//            )
//        )



//        LaunchedEffect(key1 = true) {
//            startAnimation = true
//            delay(3000)
//            navController.popBackStack()
//            navController.navigate(ROUTE_LOGIN)
//        }}}
//        Splash(alphaAnimation.value)
//    }
//
//}
//
//
//
//
//@Composable
//fun Splash(alpha:Float) {
//    val composition= rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.vm))
////            LottieCompositionSpec.RawRes(R.raw.vm) // Replace with your animation file name
////        )
//
//    val progress by animateLottieCompositionAsState(
//        composition=composition,
//
//        iterations = LottieConstants.IterateForever,
//        restartOnPlay = true
//    )
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(if (isSystemInDarkTheme()) Color.Black else Color.Black),
//        contentAlignment = Alignment.Center
//
//
//    ) {
//
//        LottieAnimation(
////            compositionSpec = animationSpec,
//            composition=composition,
//            progress = {progress},
//            modifier = Modifier.fillMaxSize()
//                .alpha(alpha = alpha)
//        )
//
//
////
////        Icon(
////
////
////
//////            imageVector = Icons.Default.Face,
//////            contentDescription = "logo",
//////            tint = Color.White,
//////            modifier = Modifier.fillMaxSize()
//////                .alpha(alpha=alpha)
////
////        )
//
//
//    }
//
//
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun SplashPreview() {
//    Splash(alpha = 1f)
//
//
//}
//
//fun Splash(alpha: Float) {
//
//}
//
//@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun SplashScreenDarkPreview() {
//    Splash(alpha = 1f)
//
//
//}
@Composable
fun SplashScreen(navController: NavHostController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.vm))
    var isPlaying by remember {
        mutableStateOf(true)


    }
    val progress by animateLottieCompositionAsState(composition = composition)
    var startAnimation by remember { mutableStateOf(false) }
//
        val alphaAnimation = animateFloatAsState(
            targetValue = if (startAnimation) 1f else 0f,
            animationSpec = tween(
                durationMillis = 2000
            )
        )
    LaunchedEffect(key1 = progress){
        if (progress==0f){
            isPlaying= false
        }
        if (progress==1f){
            isPlaying=true
        }
        startAnimation = true
            delay(3000)
            navController.popBackStack()
            navController.navigate(ROUTE_LOGIN)

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
//        isPlaying=isPlaying)

    Column(
        modifier=Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition = composition,
            modifier = Modifier.size(400 .dp),
            progress = { progress},

            )
        Text(text = "VPals")



    }
}}




