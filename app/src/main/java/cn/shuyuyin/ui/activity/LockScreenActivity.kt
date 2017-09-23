package cn.shuyuyin.ui.activity

import android.os.Bundle
import android.view.WindowManager
import cn.shuyuyin.R

/**
 * Created by wz on 17-9-23.
 */

class LockScreenActivity : SwipeBackActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        this.window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        super.onCreate(savedInstanceState)
    }

    override fun setLayoutView(): Int {
        return R.layout.activity_lock_screen
    }

    override fun init() {

    }

    override fun onBackPressed() {
        // do nothing
    }
}
