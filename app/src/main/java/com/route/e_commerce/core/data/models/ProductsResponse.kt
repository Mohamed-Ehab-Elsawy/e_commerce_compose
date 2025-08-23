package com.route.e_commerce.core.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(

    @field:SerializedName("metadata")
    val metadata: Metadata? = null,

    @field:SerializedName("data")
    val data: List<ProductModel?>? = null,

    @field:SerializedName("results")
    val results: Int? = null
)