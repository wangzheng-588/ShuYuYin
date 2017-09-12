package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.MyMessageBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-12.
 */
class MyMessageAdapter(layoutResId:Int = R.layout.item_my_message, data:List<MyMessageBean>):BaseQuickAdapter<MyMessageBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: MyMessageBean?) {

    }
}