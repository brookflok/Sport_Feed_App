package com.damir.sportapp

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.MenuItem
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.damir.sportapp.data.models.FeedView
import kotlinx.android.synthetic.main.activity_video.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.logging.Level.parse


class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val actionBar = supportActionBar
        actionBar!!.title = "Video"
        actionBar.setDisplayHomeAsUpEnabled(true)
        init()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun init(){
        val feedView : FeedView = intent.extras!!.get("FeedView") as FeedView

        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        video_name.text = "Name: " + feedView.athlete.name
        video_bio.text = "Age : ${feedView.athlete.age} From: ${feedView.athlete.country.name}"
        video_description.text = feedView.description
        video_views.text = feedView.athlete.club
        video_club.text ="Watched: ${feedView.views}"
        videoView.videoUrl(feedView.video.url)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}