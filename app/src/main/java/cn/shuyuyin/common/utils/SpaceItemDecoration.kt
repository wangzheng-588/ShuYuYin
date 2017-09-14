package cn.shuyuyin.common.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import cn.shuyuyin.ui.adapter.CategoryDetailAdapter

/**
 * Created by wz on 17-9-14.
 */

class SpaceItemDecoration(private val type:Int,private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        //不是第一个的格子都设一个左边和底部的间距


        //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0

        if (type== CategoryDetailAdapter.RECOMMEND){

            outRect.left = space
            outRect.right = space

        }
    }


}
