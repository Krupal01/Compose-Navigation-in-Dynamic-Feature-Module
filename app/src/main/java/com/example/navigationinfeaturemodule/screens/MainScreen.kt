package com.example.navigationinfeaturemodule.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.navigationinfeaturemodule.navigation.NavigationObject
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory

const val TAG = "TAG"
@Composable
fun MainScreen(
    navController: NavController,
    gotoDynamic : (String) -> Unit
) {
    val context = LocalContext.current
    val splitInstallManager : SplitInstallManager = SplitInstallManagerFactory.create(context)
    var sessionId = 0
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {gotoDynamic("app://com.example.dynamicfeature.featurescreen1")}) {
            Text(text = "goto dynamic feature1")
        }
        Button(onClick = {gotoDynamic("app://com.example.dynamicfeature.featurescreen2")}) {
            Text(text = "goto dynamic feature2")
        }
        Button(onClick = {gotoDynamic("app://com.example.dynamicfeature.featurescreen3")}) {
            Text(text = "goto dynamic feature3")
        }
        Button(onClick = {
            navController.navigate(NavigationObject.MainScreen2route.destination)
        }) {
            Text(text = "goto main screen 2")
        }
    }
}


@Composable
fun MainScreen2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MainScreen2")
    }
}