package com.damir.sportapp.ui.presenter



import com.damir.sportapp.data.api.TechnicalTaskAPI
import com.damir.sportapp.data.models.FeedView
import com.damir.sportapp.ui.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainPresenter(private val view : MainView){

    @Inject
   lateinit var api: TechnicalTaskAPI



    fun getFeed(){
        view.showSpinner()
        api.getFeed()
            .enqueue(object : Callback<List<FeedView>> {
                override fun onResponse(
                    call: Call<List<FeedView>>,
                    response: Response<List<FeedView>>
                ) {
                    updateFeed(response.body()!!)
                    view.hideSpinner()
                }

                override fun onFailure(call: Call<List<FeedView>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

    private fun updateFeed(feedView: List<FeedView>){
        view.updateFeed(feedView)
    }


    }