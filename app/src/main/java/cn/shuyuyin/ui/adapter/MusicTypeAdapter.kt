package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.TopicBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */

class MusicTypeAdapter(layoutResId: Int = R.layout.item_topic, data: List<TopicBean>?) : BaseQuickAdapter<TopicBean, BaseViewHolder>(layoutResId, data) {


    override fun convert(helper: BaseViewHolder, item: TopicBean) {



    }
}