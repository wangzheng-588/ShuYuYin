package cn.shuyuyin.ui.activity

import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.ActivityUtil
import cn.shuyuyin.ui.base.BaseActivity


/**
 * Created by wz on 17-9-11.
 */
class WelcomeActivity:BaseActivity() {

    private val IS_FIRST = "IS_FIRST"//是否是第一次使用本软件
  //  val aCache = ACache.get(this)

    private val mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
    }


    override fun setLayoutView(): Int {
        return R.layout.activity_welcome
    }

    override fun init() {



//        val isFirst = SPUtil.getBoolean(this, IS_FIRST, true)
        val isFirst = false
        if (isFirst) {
            mHandler.postDelayed({ ActivityUtil.startActivityWithFinish(this@WelcomeActivity, GuideActivity::class.java, null) }, 2000)

        } else {
            goToLoginActivity()
        }

    }


    private fun goToLoginActivity() {


        mHandler.postDelayed({
          //  aCache.put(IS_FIRST,false)
//            SPUtil.putBoolean(this@WelcomeActivity, IS_FIRST, false)
            ActivityUtil.startActivityWithFinish(this@WelcomeActivity, LoginActivity::class.java, null)
        }, 2000)

    }
}