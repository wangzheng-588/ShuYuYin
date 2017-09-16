package cn.shuyuyin.ui.activity

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_goods_detail.*

/**
 * Created by wz on 17-9-14.
 * 商城详情
 */
class GoodsDetailActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_goods_detail
    }

    override fun initListener() {
        super.initListener()


        tv_add_cart.setOnClickListener {

            showGenderBottomPopWindow(window)

        }

    }

    override fun init() {

    }







    //底部弹出的popWindow
    private fun showGenderBottomPopWindow(window: Window): PopupWindow {
        val popupWindowView = View.inflate(this, R.layout.popupwindow_goods_parameter, null)

        //        View popupWindowView = View.inflate(mContext, R.layout.case_sharing_pop, null);
        val mPopupWindow = PopupWindow(popupWindowView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        mPopupWindow.inputMethodMode = PopupWindow.INPUT_METHOD_NEEDED
        mPopupWindow.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        mPopupWindow.isFocusable = false
        mPopupWindow.setBackgroundDrawable(BitmapDrawable())
        //添加pop窗口关闭事件
        mPopupWindow.setOnDismissListener { backgroundAlpha(1f, window) }
        mPopupWindow.animationStyle = R.style.MyPopupWindow_anim_style

        val ivCancel = popupWindowView.findViewById<ImageView>(R.id.iv_cancel)
        val btnConfirmOrder = popupWindowView.findViewById<Button>(R.id.btn_confirm_order)

        btnConfirmOrder.setOnClickListener {
            startActivity(Intent(this@GoodsDetailActivity,ConfirmOrderActivity::class.java))
        }


        ivCancel.setOnClickListener {
          mPopupWindow.dismiss()
        }


        mPopupWindow.showAtLocation(popupWindowView, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
        backgroundAlpha(0.5f, window)
        return mPopupWindow
    }


    private fun backgroundAlpha(bgAlpha: Float, window: Window) {
        val lp = window.attributes
        lp.alpha = bgAlpha //0.0-1.0
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.attributes = lp
    }



}