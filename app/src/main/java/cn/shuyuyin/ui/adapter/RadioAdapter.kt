package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.RadioBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-14.
 */
class RadioAdapter(layoutResId:Int= R.layout.item_radio,data:List<RadioBean>):BaseQuickAdapter<RadioBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: RadioBean?) {

    }

}