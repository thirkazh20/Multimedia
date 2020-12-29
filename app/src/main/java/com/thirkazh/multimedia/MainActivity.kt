package com.thirkazh.multimedia

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // enable & disable beberapa button
        btnPlay.isEnabled = true
        btnPause.isEnabled = false
        btnStop.isEnabled = false
        btnResume.isEnabled = false

        // action play
        btnPlay.setOnClickListener {

            val uri = Uri.parse("android.resource://$packageName/${R.raw.music}")

            mediaPlayer = MediaPlayer()
            mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
            mediaPlayer?.setDataSource(this,uri)
            mediaPlayer?.prepare()
            mediaPlayer?.start()

            // enable & disable beberapa button
            btnPlay.isEnabled = false
            btnPause.isEnabled = true
            btnStop.isEnabled = true
            btnResume.isEnabled = false
        }

        btnPause.setOnClickListener {

            if (mediaPlayer?.isPlaying!!){
                mediaPlayer?.pause()
            }

            // enable & disable beberapa button
            btnPlay.isEnabled = false
            btnPause.isEnabled = false
            btnStop.isEnabled = false
            btnResume.isEnabled = true
        }

        btnStop.setOnClickListener {

            if (mediaPlayer?.isPlaying!! && mediaPlayer != null){
                mediaPlayer?.stop()
            }

            // enable & disable beberapa button
            btnPlay.isEnabled = true
            btnPause.isEnabled = false
            btnStop.isEnabled = false
            btnResume.isEnabled = false

        }

        btnResume.setOnClickListener {

            mediaPlayer?.start()

            // enable & disable beberapa button
            btnPlay.isEnabled = false
            btnPause.isEnabled = true
            btnStop.isEnabled = true
            btnResume.isEnabled = false
        }

        btnVideo.setOnClickListener {

            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }

        btnStreaming.setOnClickListener {

            val intent = Intent(this,VideoStreaming::class.java)
            startActivity(intent)
        }

    }
}
