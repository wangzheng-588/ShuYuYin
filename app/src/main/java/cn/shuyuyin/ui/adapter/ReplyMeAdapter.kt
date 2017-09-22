package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.ReplyMeBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-22.
 */
class ReplyMeAdapter(layoutResId:Int = R.layout.item_reply_me, data:List<ReplyMeBean>):BaseQuickAdapter<ReplyMeBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: ReplyMeBean?) {
    }
}