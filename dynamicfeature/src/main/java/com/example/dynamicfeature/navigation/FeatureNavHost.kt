package com.example.dynamicfeature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dynamicfeature.screens.FeatureScreen1
import com.example.dynamicfeature.screens.FeatureScreen2
import com.example.dynamicfeature.screens.FeatureScreen3
import com.example.navigationinfeaturemodule.screens.MainScreen
import com.example.navigationinfeaturemodule.screens.MainScreen2

@Composable
fun FeatureNavHost() {


    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = NavigationObject.FeatureScreen1route.destination ){


        composable(
            route = NavigationObject.FeatureScreen1route.destination,
            deepLinks = NavigationObject.FeatureScreen1route.deeplink
        ){
            FeatureScreen1()
        }

        composable(
            route = NavigationObject.FeatureScreen2route.destination,
            deepLinks = NavigationObject.FeatureScreen2route.deeplink
        ){
            FeatureScreen2()
        }

        composable(
            route = NavigationObject.FeatureScreen3route.destination,
            deepLinks = NavigationObject.FeatureScreen3route.deeplink
        ){
            FeatureScreen3()
        }


    }
    
}