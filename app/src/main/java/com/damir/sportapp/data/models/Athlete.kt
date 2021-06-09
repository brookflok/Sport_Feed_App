package com.damir.sportapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Athlete(
    @SerializedName("age") val age: Int = 0,
    @SerializedName("avatar")  val avatar: String ="",
    @SerializedName("club")  val club: String ="",
    @SerializedName("country") val country: Country = Country(),
    @SerializedName("id") val id: Int = 0,
    @SerializedName("isCelebrity") val isCelebrity: Boolean = false,
    @SerializedName("name") val name: String = "",
    @SerializedName("sport") val sport: Sport = Sport()
) : Serializable