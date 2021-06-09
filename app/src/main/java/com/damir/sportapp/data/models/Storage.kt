package com.damir.sportapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Storage(
    @SerializedName("totalAvailable") val totalAvailable: Int,
    @SerializedName("used") val used: Double
) : Serializable