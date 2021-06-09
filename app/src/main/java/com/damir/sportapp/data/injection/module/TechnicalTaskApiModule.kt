package com.damir.sportapp.data.injection.module

import com.damir.sportapp.data.api.TechnicalTaskAPI
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [GsonModule::class])
class TechnicalTaskApiModule {

    @Provides @Singleton
    fun provideApi(gson: Gson) : TechnicalTaskAPI{

        return Retrofit.Builder().apply {
            baseUrl(TechnicalTaskAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
        }.build().create(TechnicalTaskAPI::class.java)

    }


}