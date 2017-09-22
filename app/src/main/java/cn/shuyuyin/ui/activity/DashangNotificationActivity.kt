package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.DashangNotificationBean
import cn.shuyuyin.ui.adapter.DashangNotificationAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dashang_notification.*

/**
 * Created by wz on 17-9-22.
 * 打赏通知
 */
class DashangNotificationActivity: BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_dashang_notification
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

        val list = ArrayList<DashangNotificationBean>()

        (1..100).mapTo(list){ DashangNotificationBean(it) }

        recycler_view.adapter = DashangNotificationAdapter(data = list)

        recycler_view.layoutManager = LinearLayoutManager(this)

    }
}