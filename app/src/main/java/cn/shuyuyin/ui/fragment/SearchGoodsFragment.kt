package cn.shuyuyin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.SearchGoodsBean
import cn.shuyuyin.ui.adapter.SearchGoodsAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_goods.*

/**
 * Created by wz on 17-9-19.
 * 搜索商品
 */
class SearchGoodsFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_search_goods
    }

//    item_shopping_mall_category
    override fun initData() {

    val list = ArrayList<SearchGoodsBean>()
    (1..100).mapTo(list) { SearchGoodsBean(it) }

    recycler_view_search_goods.adapter = SearchGoodsAdapter(data = list)
    val gridLayoutManager = GridLayoutManager(mContext, 2)
    recycler_view_search_goods.layoutManager = gridLayoutManager



    }
}