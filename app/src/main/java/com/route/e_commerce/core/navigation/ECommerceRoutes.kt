package com.route.e_commerce.core.navigation

sealed class ECommerceRoutes(val route: String) {
    data object Splash : ECommerceRoutes("/")
    data object Login : ECommerceRoutes("/login")
    data object Signup : ECommerceRoutes("/signup")
    data object ForgotPassword : ECommerceRoutes("/forgot_password")
    data object ResetPassword : ECommerceRoutes("reset_password/{email}") {
        fun passEmail(email: String) = "reset_password/$email"
    }
    data object Home : ECommerceRoutes("/home")
    data object Profile : ECommerceRoutes("/profile")
    data object Cart : ECommerceRoutes("/cart")
    data object Checkout : ECommerceRoutes("/checkout")
    data object ProductDetails : ECommerceRoutes("/product_details")
    data object Search : ECommerceRoutes("/search")
}