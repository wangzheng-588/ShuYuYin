package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.PersonalWenZhangListBean
import cn.shuyuyin.ui.activity.TopicActivity
import cn.shuyuyin.ui.adapter.PersonalWenZhangListAdapter
import cn.shuyuyin.ui.base.BaseFragment

import kotlinx.android.synthetic.main.fragment_personal_wenzhang.*

/**
 * Created by wz on 17-9-8.
 * 个人文章fragment
 */
class MyFollowWenZhangFragment : BaseFragment() {
    override fun setLayoutResID(): Int {
       return R.layout.fragment_personal_wenzhang
    }

    override fun initData() {

        val personalWenzhangList = ArrayList<PersonalWenZhangListBean>()
        for(i in 1..100){
            personalWenzhangList.add(PersonalWenZhangListBean(i))
        }

        val adapter = PersonalWenZhangListAdapter(context = mContext, data = personalWenzhangList)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)

        adapter.setOnItemClickListener { adapter, view, position ->


            startActivity(Intent(mContext,TopicActivity::class.java))

        }

    }
}