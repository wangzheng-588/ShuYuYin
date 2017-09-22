package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.ReplyMeBean
import cn.shuyuyin.ui.adapter.ReplyMeAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_reply_me.*

/**
 * Created by wz on 17-9-22.
 * 回复我的
 */
class ReplyMeActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_reply_me
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

        val list = ArrayList<ReplyMeBean>()

        (1..100).mapTo(list){ ReplyMeBean(it) }
        recycler_view.adapter = ReplyMeAdapter(data = list)
        recycler_view.layoutManager = LinearLayoutManager(this)

    }
}