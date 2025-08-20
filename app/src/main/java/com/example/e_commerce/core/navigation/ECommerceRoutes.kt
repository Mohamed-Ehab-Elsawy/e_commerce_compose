package com.example.e_commerce.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.e_commerce.features.auth.forget_password.presentation.ForgetPasswordView
import com.example.e_commerce.features.auth.login.presentation.LoginView
import com.example.e_commerce.features.auth.signup.presentation.SignupView
import com.example.e_commerce.features.home.presentation.HomeView
import com.example.e_commerce.features.splash.presentation.SplashView

sealed class ECommerceRoutes(val route: String) {
    data object Splash : ECommerceRoutes("/")
    data object Login : ECommerceRoutes("/login")
    data object Signup : ECommerceRoutes("/signup")
    data object ForgotPassword : ECommerceRoutes("/forgotPassword")
    data object Home : ECommerceRoutes("/home")
    data object Profile : ECommerceRoutes("/profile")
    data object Cart : ECommerceRoutes("/cart")
    data object Checkout : ECommerceRoutes("/checkout")
    data object ProductDetails : ECommerceRoutes("/productDetails")
    data object Search : ECommerceRoutes("/search")
}

@Composable
fun ECommerceGraph(navController: NavHostController) {
    NavHost(startDestination = ECommerceRoutes.Splash.route, navController = navController) {
        composable(route = ECommerceRoutes.Splash.route) {
            SplashView(navController = navController)
        }
        composable(route = ECommerceRoutes.Login.route) {
            LoginView(navController = navController)
        }
        composable(route = ECommerceRoutes.Signup.route) {
            SignupView(navController = navController)
        }
        composable(route = ECommerceRoutes.ForgotPassword.route) {
            ForgetPasswordView(navController = navController)
        }
        composable(route = ECommerceRoutes.Home.route) {
            HomeView(navController = navController)
        }
    }
}