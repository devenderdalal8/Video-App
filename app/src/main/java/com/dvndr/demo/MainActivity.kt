package com.dvndr.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)
        val videoId = "lT4sKp3OQwI"

        val img_url = "https://i.ytimg.com/vi/" + videoId + "/hq720.jpg"
        Glide.with(this).load(img_url).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .skipMemoryCache(true)
            .into(image)

        image.setOnClickListener({
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("id", videoId)
            startActivity(intent)
        })

}
}