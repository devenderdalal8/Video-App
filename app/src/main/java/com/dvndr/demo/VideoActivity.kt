package com.dvndr.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoId = intent.getStringExtra("id")

        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)

        getLifecycle().addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                if (videoId != null)
                {

                    youTubePlayer.loadVideo(videoId, 0F)

                }
            }
        })

    }
}