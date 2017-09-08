package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

import cn.shuyuyin.bean.TopicBean

/**
 * Created by wz on 17-9-8.
 */

class TopicAdapter(layoutResId: Int = R.layout.item_topic , data: List<TopicBean>?) : BaseQuickAdapter<TopicBean, BaseViewHolder>(layoutResId, data) {


    override fun convert(helper: BaseViewHolder, item: TopicBean) {




    }
}
