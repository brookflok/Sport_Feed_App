package com.damir.sportapp.data.injection.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GsonModule {
    @Provides @Singleton
    fun provideGson() : Gson{
        return GsonBuilder().create()
    }
}