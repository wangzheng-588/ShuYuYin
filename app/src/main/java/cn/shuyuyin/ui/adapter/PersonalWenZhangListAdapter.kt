package cn.shuyuyin.ui.adapter

import android.content.Context
import android.widget.ImageView
import cn.shuyuyin.R
import cn.shuyuyin.bean.PersonalWenZhangListBean
import cn.shuyuyin.common.utils.ShareUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-8.
 */
class PersonalWenZhangListAdapter(val context: Context, layoutResId:Int = R.layout.item_personal_wenzhang, data:List<PersonalWenZhangListBean>):BaseQuickAdapter<PersonalWenZhangListBean,BaseViewHolder>(layoutResId,data) {



    override fun convert(helper: BaseViewHolder?, item: PersonalWenZhangListBean?) {

        helper!!.getView<ImageView>(R.id.iv_share).setOnClickListener {
            ShareUtils.showShare(context)
        }

    }

}