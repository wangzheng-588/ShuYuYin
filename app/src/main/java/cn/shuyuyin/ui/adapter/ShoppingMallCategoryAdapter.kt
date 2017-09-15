package cn.shuyuyin.ui.adapter

import android.widget.TextView
import cn.shuyuyin.R
import cn.shuyuyin.bean.ShoppingMallCategoryBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-15.
 */
class ShoppingMallCategoryAdapter(layoutResId:Int= R.layout.item_mall_category, data:List<ShoppingMallCategoryBean>):BaseQuickAdapter<ShoppingMallCategoryBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: ShoppingMallCategoryBean?) {

        helper!!.getView<TextView>(R.id.tv_name).paint.isFakeBoldText = true
        helper.getView<TextView>(R.id.tv_type).paint.isFakeBoldText = true





    }

}