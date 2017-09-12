package cn.shuyuyin.ui.adapter

import cn.shuyuyin.R
import cn.shuyuyin.bean.MyFollowPeopleBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-12.
 */
class MyFollowPeopleAdapter(layoutResId:Int = R.layout.item_my_follow_people, data:List<MyFollowPeopleBean>):BaseQuickAdapter<MyFollowPeopleBean,BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: MyFollowPeopleBean?) {

    }
}