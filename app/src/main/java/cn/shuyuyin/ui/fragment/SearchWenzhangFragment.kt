package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.PersonalWenZhangListBean
import cn.shuyuyin.ui.adapter.SearchWenzhangAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_wenzhang.*

/**
 * Created by wz on 17-9-19.
 * 搜索文章
 */
class SearchWenzhangFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_search_wenzhang
    }

    override fun initData() {

        val list = ArrayList<PersonalWenZhangListBean>()

        (1..100).mapTo(list){ PersonalWenZhangListBean(it) }

        recycler_view_search_wenzhang.adapter = SearchWenzhangAdapter(context = mContext,data=list)
        recycler_view_search_wenzhang.layoutManager = LinearLayoutManager(mContext)
    }
}