package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activityy_music_listener_detail.*

/**
 * Created by wz on 17-9-25.
 */
class MusicListenerDetailActivity :BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activityy_music_listener_detail
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
        ib_music.setOnClickListener {
            startActivity(Intent(this,AudioPlayActivity::class.java))
        }
    }

    override fun init() {

    }
}