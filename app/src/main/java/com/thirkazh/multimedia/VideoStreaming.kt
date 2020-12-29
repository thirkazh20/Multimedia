package com.thirkazh.multimedia

import android.app.ProgressDialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_streaming.*

class VideoStreaming : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_streaming)

        val urlMovie = "https://www.dropbox.com/s/2xziljidxo1jzva/Moana.mp4?dl=1"

        val controller = MediaController(this)
        controller.setAnchorView(video_streaming)
        video_streaming.setMediaController(controller)

        video_streaming.setVideoURI(Uri.parse(urlMovie))
        video_streaming.requestFocus()

        var loading = ProgressDialog(this)
        loading.setMessage("Loading")
        loading.setCancelable(false)
        loading.show()

        video_streaming.setOnPreparedListener {
            it.start()
            loading.dismiss()
        }
    }
}
