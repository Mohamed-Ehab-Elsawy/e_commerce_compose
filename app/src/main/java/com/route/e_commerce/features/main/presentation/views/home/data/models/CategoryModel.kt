package com.route.e_commerce.features.main.presentation.views.home.data.models

import com.google.gson.annotations.SerializedName
import com.route.e_commerce.core.data.entities.CategoryEntity
import kotlinx.serialization.Serializable

@Serializable
data class CategoryModel(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) {
    fun toCategoryEntity(): CategoryEntity = CategoryEntity(
        id = id,
        name = name,
        image = image
    )
}