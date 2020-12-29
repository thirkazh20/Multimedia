package com.thirkazh.multimedia

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.androidcommercial}")

        val controller = MediaController(this)
        controller.setAnchorView(video_view)
        video_view.setMediaController(controller)

        video_view.setVideoURI(uri)
        video_view.requestFocus()
        video_view.start()
    }
}
