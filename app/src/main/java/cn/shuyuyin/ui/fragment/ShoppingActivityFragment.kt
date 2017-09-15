package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.ShoppingMallActivityBean
import cn.shuyuyin.ui.adapter.ShoppingMallActivityAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_shopping_mall_activity.*

/**
 * Created by wz on 17-9-14.
 * 商城活动
 */
class ShoppingActivityFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_shopping_mall_activity
    }

    override fun initData() {
        val list = ArrayList<ShoppingMallActivityBean>()

        for (i in 1..100){
            list.add(ShoppingMallActivityBean(i))
        }

        recycler_view_activity.adapter = ShoppingMallActivityAdapter(context = mContext,data = list)
        recycler_view_activity.layoutManager = LinearLayoutManager(mContext)
    }
}