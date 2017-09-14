package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.RadioBean
import cn.shuyuyin.ui.activity.RadioDetailActivity
import cn.shuyuyin.ui.adapter.RadioAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_radio.*

/**
 * Created by wz on 17-9-14.
 * 电台
 */
class RadioFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_radio
    }

    override fun initData() {

        val radioList = ArrayList<RadioBean>()

        for (i in 1..100){
            radioList.add(RadioBean(i))
        }

        val adapter = RadioAdapter(data=radioList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)

        adapter.setOnItemClickListener { adapter, view, position ->

            startActivity(Intent(mContext, RadioDetailActivity::class.java))

        }

    }
}