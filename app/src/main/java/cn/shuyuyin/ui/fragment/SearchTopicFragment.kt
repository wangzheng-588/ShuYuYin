package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.SearchTopicAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_topic.*

/**
 * Created by wz on 17-9-19.
 * 搜索话题
 */
class SearchTopicFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_search_topic
    }

    override fun initData() {

        recycler_view_search_topic.adapter = SearchTopicAdapter(mContext)
        recycler_view_search_topic.layoutManager = LinearLayoutManager(mContext)


    }
}