package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_message.*

/**
 * Created by wz on 17-9-12.
 * 我的消息
 */
class MyMessageActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_my_message
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true

    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

        //回复我的
        ll_reply_me.setOnClickListener { startActivity(Intent(this,ReplyMeActivity::class.java)) }

        //@我的
        ll_at_me.setOnClickListener {  }

        //粉丝通知
        _ll_fan_notification.setOnClickListener { startActivity(Intent(this,FanNotificationActivity::class.java)) }

        //收到的赞
        ll_received_praise.setOnClickListener { startActivity(Intent(this,ReceivedPraiseActivity::class.java)) }

        //打赏通知
        ll_dashang_notification.setOnClickListener{startActivity(Intent(this,DashangNotificationActivity::class.java))}

        //系统消息
        ll_system_message.setOnClickListener { startActivity(Intent(this,SystemMessageActivity::class.java)) }
    }

    override fun init() {

    }
}