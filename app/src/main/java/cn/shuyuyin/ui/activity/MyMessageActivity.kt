package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.MyMessageBean
import cn.shuyuyin.ui.adapter.MyMessageAdapter
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
    }

    override fun init() {

        val myMessageList = ArrayList<MyMessageBean>()
        for (i in 1..100){

            myMessageList.add(MyMessageBean(i))
        }

        val adapter = MyMessageAdapter(data = myMessageList)
        recycler_view.adapter =adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener { adapter, view, position ->

            startActivity(Intent(this,CommentListActivity::class.java))

        }
    }
}