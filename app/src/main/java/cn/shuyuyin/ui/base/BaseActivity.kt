package cn.shuyuyin.ui.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import com.zhy.autolayout.AutoLayoutActivity
import android.view.View
import cn.shuyuyin.common.utils.StatusBarUtil


/**
 * Created by wz on 17-9-7.
 * BaseActivity
 */
abstract class  BaseActivity: AutoLayoutActivity() {


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

}