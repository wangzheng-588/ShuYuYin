package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.YanChangHuiActivityBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-9.
 */
class YanChangHuiActivityAdapter(layoutResId:Int = R.layout.item_yanchanghui_activity, data:List<YanChangHuiActivityBean>):BaseQuickAdapter<YanChangHuiActivityBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: YanChangHuiActivityBean?) {

    }
}