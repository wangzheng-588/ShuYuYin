package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.ShoppingMallCategoryBean
import cn.shuyuyin.ui.activity.RecommendDetailActivity
import cn.shuyuyin.ui.adapter.ShoppingMallCategoryAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_shopping_mall_categgory.*

/**
 * Created by wz on 17-9-14.
 * 商城分类
 */
class ShoppingMallCategoryFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_shopping_mall_categgory
    }

    override fun initData() {

        val categoryList = ArrayList<ShoppingMallCategoryBean>()

        for (i in 1..100){
            categoryList.add(ShoppingMallCategoryBean(i))
        }

        val adapter = ShoppingMallCategoryAdapter(data = categoryList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)

        adapter.setOnItemClickListener { adapter, view, position ->

            val intent = Intent(mContext, RecommendDetailActivity::class.java)
            intent.putExtra("type",1)
            startActivity(intent)
        }

    }
}