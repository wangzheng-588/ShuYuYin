package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.GoodsSearchResultBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-15.
 */
class GoodsSearchResultAdapter(layoutResId:Int = R.layout.item_shopping_mall_category, data:List<GoodsSearchResultBean>):BaseQuickAdapter<GoodsSearchResultBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: GoodsSearchResultBean?) {

    }
}