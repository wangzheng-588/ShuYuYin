package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.PersonalTopicAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_become_author_published.*

/**
 * Created by wz on 17-9-12.
 * 已发布
 */
class BecomeAuthorPublishedFragment : BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_become_author_published
    }

    override fun initData() {

        recycler_view.adapter = PersonalTopicAdapter(mContext)
        recycler_view.layoutManager = LinearLayoutManager(mContext)


    }
}