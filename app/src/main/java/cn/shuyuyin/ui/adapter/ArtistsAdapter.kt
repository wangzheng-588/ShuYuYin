package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.ArtistsBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-14.
 * 艺人adapter
 */
class ArtistsAdapter(layoutResId:Int = R.layout.item_artists,data:List<ArtistsBean>):BaseQuickAdapter<ArtistsBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: ArtistsBean?) {

    }
}