package com.example.myfitapp.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class VideoPlayerViewModel : ViewModel() {
    private var player: ExoPlayer? = null

    fun initializePlayer(context: Context, videoUrl: String) {
        if (player == null) {
            player = ExoPlayer.Builder(context).build()
            val mediaItem = MediaItem.fromUri(videoUrl)
            player?.setMediaItem(mediaItem)
            player?.prepare()
        }
    }

    fun getPlayer(): ExoPlayer {
        return player ?: throw IllegalStateException("Проигрыватель не инициализирован")
    }

    override fun onCleared() {
        super.onCleared()
        player?.release()
    }
}
