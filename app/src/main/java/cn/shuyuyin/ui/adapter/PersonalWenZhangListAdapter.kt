package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.PersonalWenZhangListBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */
class PersonalWenZhangListAdapter(layoutResId:Int = R.layout.item_personal_wenzhang, data:List<PersonalWenZhangListBean>):BaseQuickAdapter<PersonalWenZhangListBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: PersonalWenZhangListBean?) {

    }

}