package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.ShoppingMallActivityBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-15.
 */
class ShoppingMallActivityAdapter(layoutResId:Int= R.layout.item_shopping_mall_activity, data:List<ShoppingMallActivityBean>):BaseQuickAdapter<ShoppingMallActivityBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: ShoppingMallActivityBean?) {

    }
}