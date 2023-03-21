package com.ktknahmet.mobilium.model.upcoming

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class OriginalLanguage(val value: String) {
    @SerialName("en")
    En("en"),
    @SerialName("es")
    Es("es"),
    @SerialName("ja")
    Ja("ja"),
    @SerialName("ru")
    Ru("ru");
}