package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.CommentBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */
class CommentAdapter(layoutResId:Int = R.layout.item_comment,data:List<CommentBean>?):BaseQuickAdapter<CommentBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: CommentBean?) {

    }
}