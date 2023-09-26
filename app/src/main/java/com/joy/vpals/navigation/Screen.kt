package com.joy.vpals.navigation

sealed class Screen (val route:String){

    object Login:Screen("login_route")
    object Splash:Screen("login_route")



}