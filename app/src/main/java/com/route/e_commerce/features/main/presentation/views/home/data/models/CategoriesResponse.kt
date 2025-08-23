package com.route.e_commerce.features.main.presentation.views.home.data.models

import com.google.gson.annotations.SerializedName
import com.route.e_commerce.core.data.models.Metadata
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
    @field:SerializedName("metadata")
    val metadata: Metadata? = null,

    @field:SerializedName("data")
    val data: List<CategoryModel?>? = null,

    @field:SerializedName("results")
    val results: Int? = null
)