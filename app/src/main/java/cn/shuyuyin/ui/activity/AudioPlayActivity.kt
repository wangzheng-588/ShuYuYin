package cn.shuyuyin.ui.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.PopupWindow
import android.widget.SeekBar
import cn.shuyuyin.R
import cn.shuyuyin.common.listener.MyAnimatorUpdateListener
import cn.shuyuyin.common.task.DownloadTask
import cn.shuyuyin.common.utils.Config
import cn.shuyuyin.common.utils.TimeUtils
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
    private var debug = -3
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

        seekbar_audio.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    debug = progress
                    removeHandler()

                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                audioTrackChange(debug) // 用户控制进度的改变
            }

        })



        //弹出歌单
        iv_song_sheet.setOnClickListener { showSongSheetPopWindow(window) }
    }


    fun removeHandler(){
        val intent = Intent(this,MediaPlayerService::class.java)
        intent.action = Config.MUSIC_SERVICE

        intent.putExtra("MSG", Config.REMOVE_HANDLER_MESSAGE)

        startService(intent)
    }


    /**
     * 播放进度改变
     * @param progress
     */
    fun audioTrackChange(progress: Int) {
        val intent = Intent(this,MediaPlayerService::class.java)
        intent.action = Config.MUSIC_SERVICE
        intent.putExtra("url", path)
        intent.putExtra("listPosition", listposition)
        intent.putExtra("MSG", Config.MSG_CHANGE_PROGRESS)
        intent.putExtra("progress", progress)
        startService(intent)
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


        filter.addAction(MediaPlayerService.ACTION_UPDATE_INFO)
        filter.addAction(MediaPlayerService.ACTION_CURRENT_TIME)
        filter.addAction(MediaPlayerService.ACTION_MUSIC_DURATION)
        registerReceiver(musicUIBroadcastReceiver, filter)
    }





    inner class MusicUIBroadcastReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            when (action ) {
                 MediaPlayerService.ACTION_UPDATE_INFO  ->{
                    //更新UI操作
                    isPlaying = intent.getBooleanExtra("isPlaying", false)

                    if (isPlaying) {

                        iv_play.setImageResource(R.mipmap.audio_pause)

                        //暂时屏蔽旋转动画
//                        //如果已经暂停，是继续播放
//                        if(updateListener!!.isPause)updateListener!!.play()
//                        //否则就是从头开始播放
//                        else animator!!.start()

//                  // AnimationUtils.RotatesAnim(this@AudioPlayActivity,profile_image,R.anim.audio_player_cover_anim)
                    } else {
//                        updateListener!!.isPause = true
                        iv_play.setImageResource(R.mipmap.audio_play)
                    }

                }

                MediaPlayerService.ACTION_CURRENT_TIME -> {
                    val currentTime = intent.extras.get("currentTime") as Int
                    seekbar_audio.progress = currentTime
                    tv_current_time.text = TimeUtils.formatTime(currentTime.toLong())
                }

                MediaPlayerService.ACTION_MUSIC_DURATION -> {
                    val duration = intent.extras.get("duration") as Int
                    seekbar_audio.max = duration
                    tv_duration.text = TimeUtils.formatTime(duration.toLong())

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




    //底部弹出的popWindow
    fun showSongSheetPopWindow(window: Window): PopupWindow {
        val view = View.inflate(this, R.layout.popupwindow_song_sheet, null)
        //        View popupWindowView = View.inflate(mContext, R.layout.case_sharing_pop, null);
        val popupWindow = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 600, true)
        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        popupWindow.inputMethodMode = PopupWindow.INPUT_METHOD_NEEDED
        popupWindow.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        popupWindow.isFocusable = true
        popupWindow.setBackgroundDrawable(BitmapDrawable())
        //添加pop窗口关闭事件
        popupWindow.setOnDismissListener { backgroundAlpha(1f, window) }
        popupWindow.animationStyle = R.style.MyPopupWindow_anim_style

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_song_sheet)





        popupWindow.showAtLocation(View.inflate(this, R.layout.activity_audio_player, null), Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
        backgroundAlpha(0.5f, window)
        return popupWindow
    }


    private fun backgroundAlpha(bgAlpha: Float, window: Window) {
        val lp = window.attributes
        lp.alpha = bgAlpha //0.0-1.0
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.attributes = lp
    }





}