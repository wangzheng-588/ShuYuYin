package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.YanChangHuiChangDiBean
import cn.shuyuyin.ui.activity.YanChangHuiChangDiDetailActivity
import cn.shuyuyin.ui.adapter.YanChangHuiChangDiAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_yanchanghui_changdi.*

/**
 * Created by wz on 17-9-9.
 */
class YanChangHuiChangDiFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_yanchanghui_changdi
    }

    override fun init() {
        super.init()

        val changdiList = ArrayList<YanChangHuiChangDiBean>()
        for (i in 1..100){
            changdiList.add(YanChangHuiChangDiBean(i))
        }

        val adapter = YanChangHuiChangDiAdapter(data = changdiList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)

        adapter.setOnItemClickListener { adapter, view, position ->

            val intent = Intent()
            intent.setClass(mContext, YanChangHuiChangDiDetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initData() {

    }
}