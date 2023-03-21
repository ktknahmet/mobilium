package com.ktknahmet.mobilium.model.upcoming

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie (
    val dates: Dates,
    val page: Long,
    val results: List<Result>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)