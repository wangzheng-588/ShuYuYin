package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.DaShangListBean
import cn.shuyuyin.bean.PersonalMusicBean
import cn.shuyuyin.ui.base.BaseActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */
class PersonalMusicAdapter(layoutResId:Int = R.layout.item_personal_music, data:List<PersonalMusicBean>):BaseQuickAdapter<PersonalMusicBean, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: PersonalMusicBean?) {

    }
}