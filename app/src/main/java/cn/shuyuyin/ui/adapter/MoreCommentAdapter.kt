package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.MoreCommentBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-9.
 */
class MoreCommentAdapter(layoutResId:Int= R.layout.item_more_comment, data:List<MoreCommentBean>):BaseQuickAdapter<MoreCommentBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: MoreCommentBean?) {

    }
}