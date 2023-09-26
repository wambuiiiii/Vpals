package com.joy.vpals.navigation



import UserForm
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.joy.vpals.data.FormViewModel
//import com.joy.vpals.ui.theme.screens.FormScreen.UserForm
//import com.joy.vpals.ui.theme.screens.FormScreen.FormScreen

import com.joy.vpals.ui.theme.screens.Homescreen.HomeScreen
import com.joy.vpals.ui.theme.screens.SplashScreen.SplashScreen


import com.joy.vpals.ui.theme.screens.LoginScreen.LoginScreen
import com.joy.vpals.ui.theme.screens.RegisterScreen.RegisterScreen

@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASH,formViewModel: FormViewModel) {
//  mighht have a problem...return to original
    NavHost(navController = navController, modifier = modifier,startDestination = ROUTE_SPLASH){
        composable(ROUTE_SPLASH){
            SplashScreen(navController )
        }
//        composable(route = Screen.Splash.route){
//            SplashScreen(navController )
//        }

        composable(ROUTE_LOGIN){
            LoginScreen(navController )
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController )
        }
        composable(ROUTE_HOME){
            HomeScreen(navController )
        }
//
        composable(ROUTE_FORM) {
          UserForm(navController,formViewModel)
        }



    }}