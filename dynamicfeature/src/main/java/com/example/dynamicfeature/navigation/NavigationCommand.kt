package com.example.dynamicfeature.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import com.example.navigationinfeaturemodule.navigation.NavigationCommand

interface NavigationCommand {
    val arguments : List<NamedNavArgument>
    val destination : String
    val deeplink : List<NavDeepLink>

}


object NavigationObject{

    val FeatureScreen1route = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val destination: String = "featureScreen1"
        override val deeplink: List<NavDeepLink> = listOf(navDeepLink { uriPattern = "app://com.example.dynamicfeature.featurescreen1" })
    }

    val FeatureScreen2route = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val destination: String = "featureScreen2"
        override val deeplink: List<NavDeepLink> = listOf(navDeepLink { uriPattern = "app://com.example.dynamicfeature.featurescreen2" })
    }

    val FeatureScreen3route = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val destination: String = "featureScreen3"
        override val deeplink: List<NavDeepLink> = listOf(navDeepLink { uriPattern = "app://com.example.dynamicfeature.featurescreen3" })
    }
}