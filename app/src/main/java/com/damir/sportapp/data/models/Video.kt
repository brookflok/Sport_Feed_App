package com.damir.sportapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Video(
    @SerializedName("handler") val handler: String ="",
    @SerializedName("length")val length: Int = 0,
    @SerializedName("poster")val poster: String ="",
    @SerializedName("type")val type: String = "",
    @SerializedName("url") val url: String = ""
) :Serializable