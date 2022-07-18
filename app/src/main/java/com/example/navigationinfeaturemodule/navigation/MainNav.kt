package com.example.navigationinfeaturemodule.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.navigationinfeaturemodule.screens.MainScreen
import com.example.navigationinfeaturemodule.screens.MainScreen2
import com.example.navigationinfeaturemodule.screens.TAG
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

@Composable
fun MainNavHost() {

    val context = LocalContext.current
    val navController = rememberNavController()
    val action = remember(navController){DynamicAction(navController,context)}
    NavHost(navController =navController , startDestination = NavigationObject.MainScreen1route.destination ){

        composable(
            route = NavigationObject.MainScreen1route.destination
        ){
            MainScreen(
                navController = navController,
                gotoDynamic = action.onDynamicClick
            )
        }

        composable(route = NavigationObject.MainScreen2route.destination){
            MainScreen2(navController = navController)
        }

    }
}

internal data class DynamicAction(private val navController: NavController,private val context: Context){
    var sessionId = 0
    private val splitInstallManager : SplitInstallManager = SplitInstallManagerFactory.create(context)
    val splitInstallRequest = SplitInstallRequest.newBuilder()
        .addModule("DynamicFeature")
        .build()

    val onDynamicClick : (String)->Unit = {destination ->

        splitInstallManager.registerListener { it ->
            if (it.sessionId()==sessionId){
                when(it.status()){
                    SplitInstallSessionStatus.INSTALLED -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(destination))
                        context.startActivity(intent)
                    }
                    SplitInstallSessionStatus.CANCELED -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.CANCELING -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.DOWNLOADED -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.DOWNLOADING -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.FAILED -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.INSTALLING -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.PENDING -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                        TODO()
                    }
                    SplitInstallSessionStatus.UNKNOWN -> {
                        TODO()
                    }
                }
            }
        }

        if(splitInstallManager.installedModules.contains("DynamicFeature"))
        {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(destination)).setPackage(context.packageName)
            context.startActivity(intent)
        }else{
            splitInstallManager.startInstall(splitInstallRequest)
                .addOnFailureListener {
                    Log.i(TAG , it.toString())
                }
                .addOnSuccessListener { id ->
                    sessionId = id
                }
        }

    }

}