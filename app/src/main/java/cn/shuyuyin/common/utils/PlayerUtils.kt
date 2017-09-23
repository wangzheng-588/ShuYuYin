package cn.shuyuyin.common.utils

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Handler
import android.util.Log
import java.io.IOException
import java.util.*

/**
 * Created by wz on 17-9-22.
 * 播放网络音乐帮助类
 */

class PlayerUtils// 初始化播放器
 : MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {

    var mediaPlayer: MediaPlayer? = null // 媒体播放器
    private val mTimer = Timer() // 计时器
    // 计时器
    private val timerTask = object : TimerTask() {

        override fun run() {
            if (mediaPlayer == null)
                return
//            if (mediaPlayer!!.isPlaying && seekBar.isPressed == false) {
//                handler.sendEmptyMessage(0) // 发送消息
//            }
        }
    }

    init {
        try {
            mediaPlayer = MediaPlayer()
            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)// 设置媒体流类型
            mediaPlayer!!.setOnBufferingUpdateListener(this)
            mediaPlayer!!.setOnPreparedListener(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // 每一秒触发一次
        mTimer.schedule(timerTask, 0, 1000)
    }



    private val handler = object : Handler() {
        override fun handleMessage(msg: android.os.Message) {
            val position = mediaPlayer!!.currentPosition
            val duration = mediaPlayer!!.duration
            if (duration > 0) {
                // 计算进度（获取进度条最大刻度*当前音乐播放位置 / 当前音乐时长）
//                val pos = (seekBar.max * position / duration).toLong()
//                seekBar.progress = pos.toInt()
            }
        }
    }

    fun play() {
        mediaPlayer!!.start()
    }

    /**
     *
     * @param url
     * url地址
     */
    fun playUrl(url: String) {
        try {
            mediaPlayer!!.reset()
            mediaPlayer!!.setDataSource(url) // 设置数据源
            mediaPlayer!!.prepare() // prepare自动播放
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    // 暂停
    fun pause() {
        mediaPlayer!!.pause()
    }

    // 停止
    fun stop() {
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

    // 播放准备
    override fun onPrepared(mp: MediaPlayer) {
        mp.start()
        Log.e("mediaPlayer", "onPrepared")
    }

    // 播放完成
    override fun onCompletion(mp: MediaPlayer) {
        Log.e("mediaPlayer", "onCompletion")
    }

    /**
     * 缓冲更新
     */
    override fun onBufferingUpdate(mp: MediaPlayer, percent: Int) {
//        seekBar.secondaryProgress = percent
//        val currentProgress = seekBar.max * mediaPlayer!!.currentPosition / mediaPlayer!!.duration
//        Log.e(currentProgress.toString() + "% play", percent.toString() + " buffer")
    }
}
