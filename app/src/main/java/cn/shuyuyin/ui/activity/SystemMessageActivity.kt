package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.SystemMessageBean
import cn.shuyuyin.ui.adapter.SystemMessageAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_my_message.*

/**
 * Created by wz on 17-9-22.
 * 系统消息
 */
class SystemMessageActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_system_message
    }

    override fun initView() {
        super.initView()
        tv_title.paint.isFakeBoldText = true

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

        val myMessageList = ArrayList<SystemMessageBean>()
        (1..100).mapTo(myMessageList) { SystemMessageBean(it) }

        val adapter = SystemMessageAdapter(data = myMessageList)
        recycler_view.adapter =adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}