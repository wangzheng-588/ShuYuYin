package cn.shuyuyin.ui.activity

import android.support.v7.widget.GridLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.GoodsSearchResultBean
import cn.shuyuyin.common.SpaceItemDecoration
import cn.shuyuyin.ui.adapter.GoodsSearchResultAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_goods_search_result.*

/**
 * Created by wz on 17-9-15.
 * 搜索结果
 */
class GoodsSearchResultActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_goods_search_result
    }


    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

        val list = ArrayList<GoodsSearchResultBean>()

        for (i in 1..100){
            list.add(GoodsSearchResultBean(i))
        }

        recycler_view.adapter = GoodsSearchResultAdapter(data = list)
        recycler_view.addItemDecoration(SpaceItemDecoration(12))

        recycler_view.layoutManager = GridLayoutManager(this,2)

    }
}