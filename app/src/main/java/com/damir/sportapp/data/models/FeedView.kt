package com.damir.sportapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FeedView (
    @SerializedName("athlete") val athlete: Athlete = Athlete(),
    @SerializedName("author") val author: Author = Author(),
    @SerializedName("bookmarked") val bookmarked: Boolean = false,
    @SerializedName("createdAt") val createdAt: String = "",
    @SerializedName("createdBefore") val createdBefore: String ="",
    @SerializedName("description") val description: String="",
    @SerializedName("id") val id: Int = 1,
    @SerializedName("sportGroup") val sportGroup: SportGroup= SportGroup(),
    @SerializedName("video") val video: Video = Video(),
    @SerializedName("views") val views: String = String()
) : Serializable
