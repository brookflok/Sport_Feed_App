package com.damir.sportapp.data.api


import com.damir.sportapp.data.models.FeedView
import retrofit2.Call
import retrofit2.http.GET


interface TechnicalTaskAPI{


    @GET("/feed")
    fun getFeed() : Call<List<FeedView>>

    companion object {
        const val BASE_URL = "https://private-anon-8e66566a12-technicaltaskapi.apiary-mock.com/"
    }

}