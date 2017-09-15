package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.GoodsCategoryDetailBean
import cn.shuyuyin.common.SpaceItemDecoration
import cn.shuyuyin.ui.activity.GoodsDetailActivity
import cn.shuyuyin.ui.adapter.GoodsCategoryDetailAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_goods_mall_categgory.*

/**
 * Created by wz on 17-9-14.
 * 商城分类
 */
class RecommendCategoryFragment : BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_goods_mall_categgory
    }

    override fun initData() {

        val list = ArrayList<GoodsCategoryDetailBean>()

        for (i in 1..100){
            list.add(GoodsCategoryDetailBean(i))
        }

        val adapter = GoodsCategoryDetailAdapter(data = list)
        recycler_view.adapter = adapter
        recycler_view.addItemDecoration(SpaceItemDecoration(12))

        recycler_view.layoutManager = GridLayoutManager(mContext,2)


        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(mContext,GoodsDetailActivity::class.java))
        }


    }
}