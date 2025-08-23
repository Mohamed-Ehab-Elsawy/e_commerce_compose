package com.route.e_commerce.core.navigation

import android.net.Uri
import com.route.e_commerce.core.data.entities.ProductEntity
import kotlinx.serialization.json.Json

sealed class ECommerceRoutes(val route: String) {
    data object Splash : ECommerceRoutes("/")
    data object Login : ECommerceRoutes("login")
    data object Signup : ECommerceRoutes("signup")
    data object ForgotPassword : ECommerceRoutes("forgot_password")
    data object ResetPassword : ECommerceRoutes("reset_password/{email}") {
        fun passEmail(email: String) = "reset_password/$email"
    }

    data object Main : ECommerceRoutes("main")
    data object Cart : ECommerceRoutes("cart")

    data object ProductDetails : ECommerceRoutes("product_details/{product}") {
        fun passProduct(product: ProductEntity): String {
            val json = Json.encodeToString(product)
            return "product_details/${Uri.encode(json)}"
        }
    }

    data object Checkout : ECommerceRoutes("/checkout")
    data object Search : ECommerceRoutes("/search")
}