package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.DaShangListBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */
class DaShangAdapter(layoutResId:Int = R.layout.item_dashang,data:List<DaShangListBean>):BaseQuickAdapter<DaShangListBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: DaShangListBean?) {

    }
}