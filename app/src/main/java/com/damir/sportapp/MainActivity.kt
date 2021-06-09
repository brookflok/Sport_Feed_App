package com.damir.sportapp

import com.damir.sportapp.data.models.FeedView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.damir.sportapp.data.injection.component.DaggerTechnicalTaskAPIComponent
import com.damir.sportapp.data.injection.module.TechnicalTaskApiModule
import com.damir.sportapp.ui.MainView
import com.damir.sportapp.ui.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var feedRecycleAdapter: FeedRecycleAdapter
    private val presenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDI()
        getFeed()
    }



    private fun initRecycleView(){
            recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            feedRecycleAdapter = FeedRecycleAdapter()
            adapter = feedRecycleAdapter
        }

    }

    override fun showSpinner() {
        loadingSpinner.visibility = View.VISIBLE
    }

    override fun hideSpinner() {
        loadingSpinner.visibility = View.GONE
    }

    override fun getFeed()  = presenter.getFeed()
    override fun updateFeed(feedView: List<FeedView>) {
       initRecycleView()
        feedRecycleAdapter.submitList(feedView)
    }
    override fun injectDI() {
        DaggerTechnicalTaskAPIComponent
            .builder()
            .technicalTaskApiModule(TechnicalTaskApiModule())
            .build()
            .inject(presenter)
    }


}
