package cn.shuyuyin.ui.adapter

import android.widget.LinearLayout
import cn.shuyuyin.R
import cn.shuyuyin.bean.SearchGoodsBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-19.
 */
class SearchGoodsAdapter(layoutResId:Int = R.layout.item_shopping_mall_category, data:List<SearchGoodsBean>):BaseQuickAdapter<SearchGoodsBean,BaseViewHolder>(layoutResId,data) {

    override fun convert(helper: BaseViewHolder?, item: SearchGoodsBean?) {

        val llRecommend = helper!!.getView<LinearLayout>(R.id.ll_recommend)

        val params = llRecommend.layoutParams as LinearLayout.LayoutParams
        if (helper.adapterPosition%2==0){

            params.rightMargin = 16
        } else{
            params.rightMargin = 0
        }

        llRecommend.layoutParams = params

    }
}