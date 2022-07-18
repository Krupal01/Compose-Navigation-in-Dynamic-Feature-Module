package com.example.dynamicfeature

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.dynamicfeature.navigation.FeatureNavHost
import com.example.dynamicfeature.screens.FeatureScreen1
import com.example.dynamicfeature.ui.theme.NavigationInFeatureModuleTheme
import com.google.android.play.core.splitcompat.SplitCompat

class FeatureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationInFeatureModuleTheme {
                // A surface container using the 'background' color from the theme
                val uri = intent.data
                Log.i("intentdata" , uri.toString())
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FeatureNavHost()
                }
            }
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.install(this)
    }

}

