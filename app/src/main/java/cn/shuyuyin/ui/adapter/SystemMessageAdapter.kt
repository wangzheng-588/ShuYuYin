package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.SystemMessageBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-12.
 */
class SystemMessageAdapter(layoutResId:Int = R.layout.item_system_message, data:List<SystemMessageBean>):BaseQuickAdapter<SystemMessageBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: SystemMessageBean?) {

    }
}