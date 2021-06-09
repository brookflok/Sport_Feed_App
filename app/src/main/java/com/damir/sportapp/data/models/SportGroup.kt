package com.damir.sportapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SportGroup(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String =""
) :Serializable