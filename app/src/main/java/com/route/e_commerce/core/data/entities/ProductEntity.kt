package com.route.e_commerce.core.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ProductEntity(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageCover: String = "",
    val brand: String = "",
    val category: String = "",
    val images: List<String?> = emptyList(),
    val sold: Int = 0,
    val stock: Int = 0,
    val price: Double = 0.0,
    val rating: Double = 0.0,
    var inFavorite: Boolean = false,
    var inCart: Boolean = false
) {
    companion object {
        val list = listOf(
            ProductEntity(title = ""),
            ProductEntity(title = ""),
            ProductEntity(title = ""),
            ProductEntity(title = "")
        )
    }
}