package com.route.e_commerce.core.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Metadata(
    @field:SerializedName("numberOfPages")
    val numberOfPages: Int? = null,
    @field:SerializedName("limit")
    val limit: Int? = null,
    @field:SerializedName("currentPage")
    val currentPage: Int? = null
)