package cn.shuyuyin.ui.activity

import android.support.v7.widget.GridLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.FanNotificationBean
import cn.shuyuyin.ui.adapter.FanNotificationAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_fan_notification.*

/**
 * Created by wz on 17-9-22.
 * 粉丝通知
 */
class FanNotificationActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_fan_notification
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

        val list = ArrayList<FanNotificationBean>()
        (1..100).mapTo(list){ FanNotificationBean(it) }

        recycler_view.adapter = FanNotificationAdapter(data = list)
        recycler_view.layoutManager = GridLayoutManager(this,3)



    }
}