package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.HomeMoreBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */
class HomeMoreAdapter(layoutResId: Int = R.layout.item_home_more, data: List<HomeMoreBean>?) : BaseQuickAdapter<HomeMoreBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: HomeMoreBean?) {

    }

}