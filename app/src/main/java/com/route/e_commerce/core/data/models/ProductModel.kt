package com.route.e_commerce.core.data.models

import com.google.gson.annotations.SerializedName
import com.route.e_commerce.core.data.entities.ProductEntity
import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(

    @field:SerializedName("sold")
    val sold: Int? = null,

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @field:SerializedName("availableColors")
    val availableColors: List<String?>? = null,

    @field:SerializedName("imageCover")
    val imageCover: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("ratingsQuantity")
    val ratingsQuantity: Int? = null,

    @field:SerializedName("ratingsAverage")
    val ratingsAverage: Double? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("subcategory")
    val subcategory: List<SubcategoryItem?>? = null,

    @field:SerializedName("category")
    val category: Category? = null,

    @field:SerializedName("brand")
    val brand: Brand? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null,

    @field:SerializedName("priceAfterDiscount")
    val priceAfterDiscount: Int? = null
) {
    fun toProductEntity(): ProductEntity = ProductEntity(
        id = id ?: "",
        title = title ?: "",
        description = description ?: "",
        imageCover = imageCover ?: "",
        brand = brand?.name ?: "",
        category = category?.name ?: "",
        images = images ?: emptyList(),
        stock = quantity ?: 0,
        sold = sold ?: 0,
        price =
            if (priceAfterDiscount != null && priceAfterDiscount == 0) price?.toDouble() ?: 0.0
            else priceAfterDiscount?.toDouble() ?: 0.0,
        rating = ratingsAverage ?: 0.0
    )
}