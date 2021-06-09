package com.damir.sportapp.ui

import com.damir.sportapp.data.models.FeedView

interface MainView{

    fun showSpinner()
    fun hideSpinner()
    fun getFeed()
    fun updateFeed(feedView: List<FeedView>)
    fun injectDI()


}