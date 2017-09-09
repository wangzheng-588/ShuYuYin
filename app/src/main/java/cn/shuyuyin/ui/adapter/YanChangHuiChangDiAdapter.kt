package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.YanChangHuiChangDiBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-9.
 */
class YanChangHuiChangDiAdapter(layoutResId:Int = R.layout.item_yanchanghui_changdi, data:List<YanChangHuiChangDiBean>):BaseQuickAdapter<YanChangHuiChangDiBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: YanChangHuiChangDiBean?) {

    }
}