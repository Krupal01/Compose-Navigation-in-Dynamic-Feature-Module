package com.example.navigationinfeaturemodule.navigation

import androidx.navigation.*

interface NavigationCommand {
    val arguments : List<NamedNavArgument>
    val destination : String
    val deeplink : List<NavDeepLink>

}

// For navigation with argument

//object DashboardNavigation {
//    private val KEY_USER_ID = "userId"
//    val route = "dashboard/{$KEY_USER_ID}"
//    val arguments = listOf(
//        navArgument(KEY_USER_ID) { type = NavType.StringType }
//    )
//    fun dashboard(
//        userId: String? = null
//    ) = object : NavigationCommand {
//        override val arguments = arguments
//        override val destination = "dashboard/$userId"
//    }
//}

object NavigationObject{

    val MainScreen1route = object : NavigationCommand{
        override val arguments: List<NamedNavArgument> = emptyList()
        override val destination: String = "mainScreen1"
        override val deeplink: List<NavDeepLink> = emptyList()
    }

    val MainScreen2route = object : NavigationCommand{
        override val arguments: List<NamedNavArgument> = emptyList()
        override val destination: String = "mainScreen2"
        override val deeplink: List<NavDeepLink> = emptyList()
    }
}