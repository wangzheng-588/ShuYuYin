package cn.shuyuyin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.ShoppingMallRecommendAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_shopping_mall_recommend.*



/**
 * Created by wz on 17-9-14.
 * 商城推荐
 */
class ShoppingMallRecommendFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_shopping_mall_recommend
    }

    override fun initData() {

        val adapter = ShoppingMallRecommendAdapter(mContext)
        recycler_view.adapter = adapter
      //  recycler_view.addItemDecoration(SpaceItemDecoration(adapter.currentType,16))
        val gridLayoutManager = GridLayoutManager(mContext,2)
        adapter.setSpanCount(gridLayoutManager)
        recycler_view.layoutManager = gridLayoutManager
    }



}