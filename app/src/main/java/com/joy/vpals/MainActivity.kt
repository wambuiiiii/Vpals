package com.joy.vpals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.joy.vpals.data.FormViewModel

import com.joy.vpals.navigation.AppNavHost
import com.joy.vpals.ui.theme.VPalsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VPalsTheme {

                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                val formViewModel = FormViewModel(navController,this)
                    AppNavHost(formViewModel = formViewModel)


            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        VPalsTheme {
            val navController = rememberNavController()

            val formViewModel = FormViewModel(navController,MainActivity())
            AppNavHost(formViewModel = formViewModel)

        }
    }
}