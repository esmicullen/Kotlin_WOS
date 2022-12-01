package com.example.gahyun_os

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import com.example.gahyun_os.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var muzic:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var btnn = findViewById<Button>(R.id.dont_btn)
        val arrayM = arrayListOf<String>("hit", "maboolji", "network_love", "second_life", "snap_shoot")
        val songTitleToId = mutableMapOf<String, Int>(
            "hit" to R.raw.hit,
            "maboolji" to R.raw.maboolji,
            "network_love" to R.raw.network_love,
            "second_life" to R.raw.second_life,
            "snap_shoot" to R.raw.snap_shoot
        )

        btnn.setOnClickListener {
            muzic.stop()
            var Rnum = Random().nextInt(5)+1
            var song = arrayM[Rnum]
            muzic = MediaPlayer.create(this, songTitleToId[song]!!)
            muzic.start()
        }

    }
}