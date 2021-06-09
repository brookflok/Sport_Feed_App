package com.damir.sportapp

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.damir.sportapp.data.models.FeedView
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.logging.Level.parse


class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val feedView : FeedView = intent.extras!!.get("FeedView") as FeedView

        val videoView : VideoView = findViewById(R.id.videoView)
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)


        val videoName : TextView = findViewById(R.id.video_name)
        val videoBio : TextView = findViewById(R.id.video_bio)
        val videoDescription : TextView = findViewById(R.id.video_description)
        val videoViews : TextView = findViewById(R.id.video_views)
        val videoClub : TextView = findViewById(R.id.video_club)



        videoName.text = "Name: " + feedView.athlete.name
        videoBio.text = "Age : ${feedView.athlete.age} From: ${feedView.athlete.country.name}"
        videoDescription.text = feedView.description
        videoClub.text = feedView.athlete.club
        videoViews.text ="Watched: ${feedView.views}"

        //specify the location of media file
        val uri: Uri = Uri.parse(feedView.video.url)
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }
}