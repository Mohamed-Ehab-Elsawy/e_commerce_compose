package com.route.e_commerce.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.route.e_commerce.core.navigation.ECommerceGraph
import com.route.e_commerce.core.ui.theme.EcommerceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            EcommerceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ECommerceGraph(navController = navController)
                }
            }
        }
    }
}