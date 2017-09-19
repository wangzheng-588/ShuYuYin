package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.SearchMusicBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-19.
 */
class SearchMusicAdapter(layoutResId:Int = R.layout.item_search_music,data:List<SearchMusicBean>):BaseQuickAdapter<SearchMusicBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: SearchMusicBean?) {

    }
}