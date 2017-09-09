package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.PersonalWenZhangListBean
import cn.shuyuyin.ui.adapter.PersonalWenZhangListAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_personal_wenzhang.*

/**
 * Created by wz on 17-9-8.
 * 个人文章fragment
 */
class PersonalWenZhangFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
       return R.layout.fragment_personal_wenzhang
    }

    override fun initData() {

        val personalWenzhangList = ArrayList<PersonalWenZhangListBean>()
        for(i in 1..100){
            personalWenzhangList.add(PersonalWenZhangListBean(i))
        }

        recycler_view.adapter = PersonalWenZhangListAdapter(context = mContext,data = personalWenzhangList)
        recycler_view.layoutManager = LinearLayoutManager(mContext)

    }
}