package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.PersonalTopicAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_personal_topic.*

/**
 * Created by wz on 17-9-12.
 * 草稿箱
 */
class DraftsFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_drafts
    }

    override fun initData() {

        recycler_view.adapter = PersonalTopicAdapter(mContext)
        recycler_view.layoutManager = LinearLayoutManager(mContext)
    }
}