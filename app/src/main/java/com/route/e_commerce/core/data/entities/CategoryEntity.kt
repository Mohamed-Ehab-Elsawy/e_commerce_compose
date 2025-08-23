package com.route.e_commerce.core.data.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
    @field:SerializedName("_id")
    val id: String? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("image")
    val image: String? = null,
) {
    companion object {
        val list = listOf(
            CategoryEntity(),
            CategoryEntity(),
            CategoryEntity(),
            CategoryEntity(),
            CategoryEntity(),
            CategoryEntity(),
        )
    }
}