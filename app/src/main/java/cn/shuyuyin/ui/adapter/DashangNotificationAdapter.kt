package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.DashangNotificationBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-22.
 */
class DashangNotificationAdapter(layoutResId:Int = R.layout.item_dashang_notification, data:List<DashangNotificationBean>): BaseQuickAdapter<DashangNotificationBean, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: DashangNotificationBean?) {
    }

}