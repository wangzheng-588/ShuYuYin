package cn.shuyuyin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import cn.shuyuyin.R
import cn.shuyuyin.bean.MyFollowPeopleBean
import cn.shuyuyin.ui.adapter.MyFollowPeopleAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_my_follow_people.*

/**
 * Created by wz on 17-9-12.
 *  我关注的  -  人
 */
class MyFollowPeopleFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_my_follow_people
    }

    override fun initData() {

        val myFollowPeopleList = ArrayList<MyFollowPeopleBean>()
        for (i in 1..100){
            myFollowPeopleList.add(MyFollowPeopleBean(i))
        }

        recycler_view.adapter = MyFollowPeopleAdapter(data = myFollowPeopleList)
        recycler_view.layoutManager = GridLayoutManager(mContext,3,RecyclerView.VERTICAL,false)

    }
}