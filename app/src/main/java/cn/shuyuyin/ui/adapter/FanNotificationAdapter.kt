package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.FanNotificationBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-22.
 */
class FanNotificationAdapter (layoutResId:Int = R.layout.item_fan_notification, data:List<FanNotificationBean>): BaseQuickAdapter<FanNotificationBean, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: FanNotificationBean?) {
    }

}