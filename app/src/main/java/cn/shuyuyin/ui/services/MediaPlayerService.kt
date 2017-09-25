package cn.shuyuyin.ui.services

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.widget.Toast
import cn.shuyuyin.bean.MusicInfoBean
import cn.shuyuyin.common.broadcast.ScreenBroadcastReceiver
import cn.shuyuyin.common.utils.Config


class MediaPlayerService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private var path: String? = null            // 音乐文件路径
    private val titleName: String? = null
    private var type0: Int = 0
    private var currentTime = 0
    private var currentposition = 0       //当前播放位置
    private var duration: Int = 0          //歌曲时长
    private var msg: Int = 0               //控制信息
    var isStart = false                 //是否开始播放音乐

    var isPlaying = false               //是否正在播放音乐


    private var musicInfos: List<MusicInfoBean>? = null    //存放MuscicInfo对象的集合


    /**
     * handler实现更新目前播放时间，循环延时更新
     * 更新当前时间
     */
    private val mHandler = object : Handler() {
        override fun handleMessage(Msg: Message) {
            if (Msg.what == 1) {
                if (null != mediaPlayer) {
                    currentTime = mediaPlayer!!.currentPosition
                    val intent = Intent()
                    intent.action = ACTION_CURRENT_TIME
                    intent.putExtra("currentTime", currentTime)
                    sendBroadcast(intent) // 给PlayerBar发送广播
                    this.sendEmptyMessageDelayed(1, 1000)
                }
            }
        }
    }


    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
        //初始为正常播放列表
        // musicInfos = CursorHandle.getMusicInfos(this@MediaPlayerService)
    }

    override fun onBind(arg0: Intent): IBinder? {

        return PlayBind()
    }


    override fun onStartCommand(intent: Intent, flag: Int, startId: Int): Int {

        //注册锁屏广播
        val receiver = ScreenBroadcastReceiver()
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        registerReceiver(receiver, filter)


        path = intent.getStringExtra("url")        //歌曲路径
        currentposition = intent.getIntExtra("listPosition", -1)    //当前播放歌曲的在mp3Infos的位置
        msg = intent.getIntExtra("MSG", 0)            //播放信息



        when (msg) {
            Config.MSG_PLAY -> {    //点击列表 直接播放音乐
                val sendIntent = Intent(ACTION_UPDATE_INFO)
                isPlaying = true
                sendIntent.putExtra("isPlaying", true)
                sendIntent.putExtra("TitleName", titleName)

                // 发送广播，将被Activity组件中的BroadcastReceiver接收到
                sendBroadcast(sendIntent)
                playMusic(0)

            }
            Config.MSG_PAUSE_RUSUME -> //暂停

                pauseNResumeMusic()
            Config.MSG_PRIVIOUS -> //上一首
                previousMusic()
            Config.MSG_NEXT -> //下一首
                nextMusic()
            Config.MSG_CHANGE_PROGRESS -> {    //点击进度条 更新音乐服务
                currentTime = intent.getIntExtra("progress", -1)
                mHandler.removeMessages(1)
                isPlaying = true
                //更新UI 主要是为了解决暂停点击seekbar 后 play button UI没更新问题
                val sendIntent = Intent(ACTION_UPDATE_INFO)
                sendIntent.putExtra("isPlaying", isPlaying)
                sendIntent.putExtra("currentposition", currentposition)
                duration = mediaPlayer!!.duration
                sendIntent.putExtra("duration", duration)
                sendBroadcast(sendIntent)
                playMusic(currentTime)

            }
            Config.REMOVE_HANDLER_MESSAGE -> {
                mHandler.removeMessages(1)
            }
//            Config.MSG_PLAY_DETAIL -> {
//                val sendIntent = Intent(ACTION_UPDATE_INFO)
//                sendIntent.putExtra("isPlaying", isPlaying)
//                sendIntent.putExtra("currentposition", currentposition)
//                duration = mediaPlayer!!.duration
//                sendIntent.putExtra("duration", duration)
//                sendBroadcast(sendIntent)
//                mHandler.sendEmptyMessage(1)
//            }
            else->{
                val sendIntent = Intent(ACTION_UPDATE_INFO)
                sendIntent.putExtra("isPlaying", isPlaying)
                sendBroadcast(sendIntent)
            }
        }
        return super.onStartCommand(intent, flag, startId)
    }


    /**
     * 播放音乐
     *
     */
    private fun playMusic(current: Int) {
        try {
            mediaPlayer!!.reset()// 把各项参数恢复到初始状态
            mediaPlayer!!.setDataSource(path)
            mediaPlayer!!.prepare() // 进行缓冲
            mediaPlayer!!.setOnPreparedListener(PreparedListener(current))// 注册一个监听器
            isStart = true
            isPlaying = true
            //mHandler.sendEmptyMessage(1);  //更新时间UI
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 暂停与开始音乐
     */
    private fun pauseNResumeMusic() {


        val sendIntent = Intent(ACTION_UPDATE_INFO)
        // 发送广播，将被Activity组件中的BroadcastReceiver接收到
        sendIntent.putExtra("currentposition", currentposition)
        duration = mediaPlayer!!.duration
        sendIntent.putExtra("duration", duration)
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            isPlaying = false
            sendIntent.putExtra("isPlaying", false)
            mediaPlayer!!.pause()
        } else {
            isPlaying = true
            sendIntent.putExtra("isPlaying", true)
            mediaPlayer!!.start()
        }
        sendBroadcast(sendIntent)
    }

    /**
     * 上一首
     */
    private fun previousMusic() {
        val sendIntent = Intent(ACTION_UPDATE_INFO)
        isPlaying = true
        sendIntent.putExtra("isPlaying", true)
        sendIntent.putExtra("currentposition", currentposition)
        // 发送广播，将被Activity组件中的BroadcastReceiver接收到
        sendBroadcast(sendIntent)
        playMusic(0)
    }

    /**
     * 下一首
     */
    private fun nextMusic() {
        val sendIntent = Intent(ACTION_UPDATE_INFO)
        isPlaying = true
        sendIntent.putExtra("isPlaying", true)
        sendIntent.putExtra("currentposition", currentposition)
        //		sendIntent.putExtra("TYPE", type);
        sendIntent.putExtra("TitleName", titleName)
        // 发送广播，将被Activity组件中的BroadcastReceiver接收到
        sendBroadcast(sendIntent)
        playMusic(0)
    }

    override fun onDestroy() {
        if (null != mediaPlayer) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
        mHandler.removeMessages(1)
    }

    /**
     *
     * 实现一个OnPrepareLister接口,当音乐准备好的时候开始播放
     *
     */
    private inner class PreparedListener(private val currentTime: Int) : OnPreparedListener {

        override fun onPrepared(mp: MediaPlayer) {
            Toast.makeText(this@MediaPlayerService, "开始播放",
                    Toast.LENGTH_SHORT).show()
            mediaPlayer!!.start() // 开始播放
            if (currentTime > 0) { // 如果音乐不是从头播放
                mediaPlayer!!.seekTo(currentTime)
            }
            //更新时间
            mHandler.sendEmptyMessage(1)
            //更新 歌曲时间
            val intent = Intent(ACTION_MUSIC_DURATION)
            duration = mediaPlayer!!.duration
            intent.putExtra("duration", duration)    //通过Intent来传递歌曲的总长度
            sendBroadcast(intent)
        }
    }

    companion object {

        val ACTION_CURRENT_TIME = "android.intent.action.ACTION_CURRENT_TIME"
        val ACTION_UPDATE_INFO = "android.intent.action.ACTION_UPDATE_INFO"
        val ACTION_MUSIC_DURATION = "android.intent.action.ACTION_MUSIC_DURATION"
    }

    inner class PlayBind : Binder() {
        fun getMediaPlayerService(): MediaPlayerService  =  this@MediaPlayerService

    }


}
	