package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.YanChangHuiActivityBean
import cn.shuyuyin.ui.activity.YanChangHuiActivityDetailActivity
import cn.shuyuyin.ui.adapter.YanChangHuiActivityAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_personal_music.*

/**
 * Created by wz on 17-9-9.
 */
class YanChangHuiActivityFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_yanchanghui_activity
    }


    override fun init() {
        super.init()

        val yanChangHuiActivtyList = ArrayList<YanChangHuiActivityBean>()
        for ( i in 1..10){
            yanChangHuiActivtyList.add(YanChangHuiActivityBean(i))
        }
        val adapter = YanChangHuiActivityAdapter(data = yanChangHuiActivtyList )
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)

        adapter.setOnItemClickListener { adapter, view, position ->


            val intent = Intent()
            intent.setClass(mContext, YanChangHuiActivityDetailActivity::class.java)
            startActivity(intent)

        }

    }



    override fun initData() {

    }
}