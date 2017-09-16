package cn.shuyuyin.ui.fragment

import android.graphics.drawable.PaintDrawable
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.TextView
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.DensityUtil
import cn.shuyuyin.ui.adapter.AftersaleAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_after_sale.*




/**
 * Created by wz on 17-9-15.
 * 售后
 */
class AfterSaleFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_after_sale
    }


    override fun initListener() {
        super.initListener()

        tv_return_reason.setOnClickListener {

            val list = ArrayList<String>()

            list.add("不想买了")
            list.add("拍错商品")
            list.add("发错，质量问题")
            list.add("七天无理由退货")

            showPopWindow(tv_return_reason,list)

        }
    }


    override fun initData() {
    }


    /**
     * @param textView 位于哪个控件之下
     */
    fun showPopWindow(textView: TextView, strings: ArrayList<String>) {
        val contentView = View.inflate(mContext, R.layout.pop_window_after_sale, null)

        val listShop = contentView.findViewById<ListView>(R.id.list_view)
        listShop.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val popupWindowAdapter = AftersaleAdapter(mContext, strings)
        listShop.adapter = popupWindowAdapter

        val mPopupWindow = PopupWindow(contentView, textView.measuredWidth, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        mPopupWindow.isFocusable = true
        mPopupWindow.setBackgroundDrawable(PaintDrawable(R.color.white))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mPopupWindow.showAsDropDown(textView, 0, 0, Gravity.CENTER)
        } else {
            mPopupWindow.contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            val xPos = DensityUtil.getScreenH(mContext) / 2 - DensityUtil.getNavigationBarrH(mContext)
            -mPopupWindow.contentView.getMeasuredHeight()
            mPopupWindow.showAtLocation(textView, Gravity.RIGHT, 0, -xPos)
        }



        listShop.setOnItemClickListener { adapterView, view, i, l ->

            textView.text = strings.get(i)
            mPopupWindow.dismiss()

        }

    }


}