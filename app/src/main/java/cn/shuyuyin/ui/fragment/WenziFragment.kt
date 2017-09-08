package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.HomeWenZiAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_wenzi.*

/**
 * Created by wz on 17-9-7.
 */

class WenziFragment: BaseFragment() {


    override fun setLayoutResID(): Int {
        return R.layout.fragment_wenzi
    }

    override fun initData() {

        recycler_view_wenzi.layoutManager = LinearLayoutManager(mContext)
        recycler_view_wenzi.adapter = HomeWenZiAdapter(mContext)
    }

}
