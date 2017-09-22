package cn.shuyuyin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.MessageSelectedBean
import cn.shuyuyin.ui.adapter.MessageSelectedAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_message_selected.*

/**
 * Created by wz on 17-9-9.
 * 消息--精选
 */
class MessageSelectedFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_message_selected
    }

    override fun initData() {

        val list = ArrayList<MessageSelectedBean>()

        (1..100).mapTo(list){ MessageSelectedBean(it) }

        val adapter = MessageSelectedAdapter(data = list)
        val gridLayoutManager = GridLayoutManager(mContext,2)
        adapter.setSpanCount(gridLayoutManager)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = gridLayoutManager


    }
}