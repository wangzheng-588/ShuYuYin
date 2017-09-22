package cn.shuyuyin.ui.adapter

import android.support.v7.widget.GridLayoutManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import cn.shuyuyin.R
import cn.shuyuyin.bean.MessageSelectedBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by wz on 17-9-22.
 */
class MessageSelectedAdapter(layoutResId:Int = R.layout.item_message_selected, data:List<MessageSelectedBean>):BaseQuickAdapter<MessageSelectedBean,BaseViewHolder>(layoutResId,data) {




    fun setSpanCount(gridLayoutManager: GridLayoutManager) {
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {

                return if (position != 2){
                    1
                } else{
                    gridLayoutManager.spanCount//独占一行
                }
            }
        }

    }

    override fun convert(helper: BaseViewHolder?, item: MessageSelectedBean?) {

        val rl_item_parent = helper!!.getView<RelativeLayout>(R.id.rl_item_parent)

        val position = helper.adapterPosition

        val params = rl_item_parent.layoutParams as LinearLayout.LayoutParams



//
//        if (position>2){
//
//            if (position%2!=0){
//                params.rightMargin = 16
//            } else{
//                params.rightMargin = 0
//            }
//        }

        when{
            position <2 ->{
                if (position%2==0){
                    params.rightMargin = 16
                } else{
                    params.rightMargin = 0
                }
            }
            position == 2->{
                params.rightMargin = 0
                params.rightMargin = 0
            }

            position >2 ->{
                if (position%2!=0){
                    params.rightMargin = 16
                } else{
                    params.rightMargin = 0
                }
            }
        }







    }
}