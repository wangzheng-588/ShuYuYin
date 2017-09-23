package cn.shuyuyin.ui.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Environment
import android.os.Handler
import cn.shuyuyin.R
import cn.shuyuyin.common.listener.MyAnimatorUpdateListener
import cn.shuyuyin.common.task.DownloadTask
import cn.shuyuyin.common.utils.Config
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.services.MediaPlayerService
import kotlinx.android.synthetic.main.activity_audio_player.*
import kotlinx.android.synthetic.main.layout_play_bottom.*
import java.io.File
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

/**
 * Created by wz on 17-9-23.
 */
class AudioPlayActivity:BaseActivity() {


    private val INVALID = -1
    private var path: String = "http://other.web.ra01.sycdn.kuwo.cn/resource/n3/128/17/55/3616442357.mp3" // url地址
    private var listposition = 0
    private var isPlaying = false // 正在播放
    private val handler: Handler = Handler()

    private var animator: ObjectAnimator? = null

    var updateListener:MyAnimatorUpdateListener? =null

    //定义和注册广播接收器
    private val musicUIBroadcastReceiver = MusicUIBroadcastReceiver()

    override fun setLayoutView(): Int {
        return R.layout.activity_audio_player
    }



    override fun init() {
        registerReceiver()
        allowBindService()


        //旋转动画
        animator = ObjectAnimator.ofFloat(profile_image,"rotation",0f,360f)
        animator!!.repeatCount = ValueAnimator.INFINITE//无限循环
        animator!!.duration = 80000
        updateListener =  MyAnimatorUpdateListener(animator!!)
        animator!!.addUpdateListener(updateListener)

    }

    override fun initListener() {
        super.initListener()
        iv_play.setOnClickListener { playMusic() }
    }


    private fun playMusic() {

        val intent = Intent(this, MediaPlayerService::class.java)

        if (!mediaPlayerService!!.isStart){

            intent.action = Config.MUSIC_SERVICE
            intent.putExtra("MSG", Config.MSG_PLAY)
            intent.putExtra("url", path)
            intent.putExtra("listPosition", listposition)



        } else{
            intent.action = Config.MUSIC_SERVICE
            intent.putExtra("MSG", Config.MSG_PAUSE_RUSUME)
            intent.putExtra("url", path)
            intent.putExtra("listPosition", listposition)

        }

        startService(intent)



    }


    private fun startDownload() {


        var filename = path.substring(path.lastIndexOf('/') + 1)

        try {
            // URL编码（这里是为了将中文进行URL编码）
            filename = URLEncoder.encode(filename, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }


        path = path.substring(0, path.lastIndexOf("/") + 1) + filename
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            // File savDir =
            // Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            // 保存路径
            val savDir = Environment.getExternalStorageDirectory()
            download(path, savDir)
        } else {
//            Toast.makeText(applicationContext,
//                    R.string.sdcarderror, Toast.LENGTH_LONG).show()
        }


    }


    private fun download(path: String, savDir: File) {
        val task = DownloadTask(this,handler,path, savDir)
        Thread(task).start()
    }




    private fun registerReceiver() {

        val filter = IntentFilter()
        filter.addAction(Config.ACTION_UPDATE_INFO)
        registerReceiver(musicUIBroadcastReceiver, filter)
    }





    inner class MusicUIBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (action == Config.ACTION_UPDATE_INFO) {
                //更新UI操作
                listposition = intent.getIntExtra("currentposition",INVALID)
                isPlaying = intent.getBooleanExtra("isPlaying", false)

                if (isPlaying) {

                    //如果已经暂停，是继续播放
                    if(updateListener!!.isPause)updateListener!!.play()
                    //否则就是从头开始播放
                    else animator!!.start()

                    //如果已经暂停，是继续播放
                    if(updateListener!!.isPause)updateListener!!.play()
                    //否则就是从头开始播放
                    else animator!!.start()
//                         AnimationUtils.RotatesAnim(this@AudioPlayActivity,profile_image,R.anim.audio_player_cover_anim)
                } else {
                    updateListener!!.isPause = true

//                    AnimationUtils.stopAnim(profile_image)
                }

                if (listposition >= 0) {
//                    musicTitle.setText(musicInfo.getTitle()) // 显示歌曲标题
//                    musicSinger.setText(musicInfo.getArtist()) //显示歌手名字
                    if (isPlaying) {
//                        playBtn.setImageResource(R.drawable.pause)
                    } else {
//                        playBtn.setImageResource(R.drawable.play)
                    }

                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        allowUnbindService()
        unregisterReceiver(musicUIBroadcastReceiver)

        animator!!.removeAllUpdateListeners()
        animator!!.removeAllListeners()

    }





}