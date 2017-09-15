package cn.shuyuyin.ui.adapter

import android.content.Context
import android.content.Intent
import android.widget.TextView
import cn.shuyuyin.R
import cn.shuyuyin.bean.ShoppingMallActivityBean
import cn.shuyuyin.ui.activity.MallActivityDetailActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-15.
 */
class ShoppingMallActivityAdapter(val context:Context,layoutResId:Int= R.layout.item_shopping_mall_activity, data:List<ShoppingMallActivityBean>):BaseQuickAdapter<ShoppingMallActivityBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: ShoppingMallActivityBean?) {

        helper!!.getView<TextView>(R.id.tv_activity_detail).setOnClickListener {
            context.startActivity(Intent(context, MallActivityDetailActivity::class.java))
        }

    }
}