package com.route.e_commerce.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.route.e_commerce.features.auth.forget_password.presentation.ForgetPasswordView
import com.route.e_commerce.features.auth.login.presentation.LoginView
import com.route.e_commerce.features.auth.reset_password.presentation.ResetPasswordView
import com.route.e_commerce.features.auth.signup.presentation.SignupView
import com.route.e_commerce.features.home.presentation.HomeView
import com.route.e_commerce.features.splash.presentation.SplashView


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
        composable(
            route = ECommerceRoutes.ResetPassword.route,
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            ResetPasswordView(navController = navController, email = email)
        }
        composable(route = ECommerceRoutes.Home.route) {
            HomeView(navController = navController)
        }
    }
}