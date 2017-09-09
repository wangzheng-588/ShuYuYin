package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.MessageHotAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_message_hot.*

/**
 * Created by wz on 17-9-9.
 * 消息--热门
 */
class MessageHotFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_message_hot
    }

    override fun init() {
        super.init()

        val adapter = MessageHotAdapter(mContext)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)

    }


    override fun initData() {

    }
}