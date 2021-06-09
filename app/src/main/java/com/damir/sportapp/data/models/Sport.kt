package com.damir.sportapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sport(
    @SerializedName("icon") val icon: String ="",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String="",
    @SerializedName("slug") val slug: String=""
) : Serializable