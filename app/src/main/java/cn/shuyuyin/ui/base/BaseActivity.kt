package cn.shuyuyin.ui.base

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.view.WindowManager
import cn.shuyuyin.common.utils.Config
import cn.shuyuyin.common.utils.StatusBarUtil
import cn.shuyuyin.ui.services.MediaPlayerService
import com.zhy.autolayout.AutoLayoutActivity


/**
 * Created by wz on 17-9-7.
 * BaseActivity
 */
abstract class BaseActivity : AutoLayoutActivity() {

    var mediaPlayerService: MediaPlayerService? = null

    private var serviceConnection: ServiceConnection? = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            mediaPlayerService = null
        }

        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            mediaPlayerService = (service as MediaPlayerService.PlayBind).getMediaPlayerService()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }

        StatusBarUtil.StatusBarLightMode(this)
//        StatusBarUtil.StatusBarLightMode(this,statusBarLightMode)

        setContentView(setLayoutView())
        initView()
        initListener()
        init()
    }


    open protected fun initView() {

    }

    open protected fun initListener() {

    }

    abstract fun setLayoutView(): Int

    abstract fun init()

    open fun allowBindService() {
        val intent = Intent(this, MediaPlayerService::class.java)
        intent.action = Config.MUSIC_SERVICE
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        startService(intent)
    }

    open fun allowUnbindService() {

        if (serviceConnection != null) {
            unbindService(serviceConnection)
            serviceConnection = null
        }

    }

}