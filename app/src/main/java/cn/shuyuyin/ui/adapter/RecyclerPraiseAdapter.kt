package cn.shuyuyin.ui.adapter

import android.content.Intent
import android.widget.TextView
import cn.shuyuyin.R
import cn.shuyuyin.bean.ReceivedPraiseBean
import cn.shuyuyin.ui.activity.ReceivedActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-22.
 */
class RecyclerPraiseAdapter (layoutResId:Int = R.layout.item_received_praise, data:List<ReceivedPraiseBean>): BaseQuickAdapter<ReceivedPraiseBean, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: ReceivedPraiseBean?) {

        helper!!.getView<TextView>(R.id.tv_received).setOnClickListener {

            mContext.startActivity(Intent(mContext, ReceivedActivity::class.java))

        }

    }

}