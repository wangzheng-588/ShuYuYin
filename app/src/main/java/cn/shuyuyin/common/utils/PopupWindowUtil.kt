package cn.shuyuyin.common.utils

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupWindow

import cn.shuyuyin.R

import android.view.View.inflate

/**
 * Created by wz on 17-7-4.
 */

class PopupWindowUtil(private val mContext: Context) {
    private var mPopupWindow: PopupWindow? = null


    //底部弹出的popWindow
    fun showGenderBottomPopWindow(window: Window): PopupWindow {
        val popupWindowView = inflate(mContext, R.layout.dialog_choice_gender_layout, null)
        //        View popupWindowView = View.inflate(mContext, R.layout.case_sharing_pop, null);
        mPopupWindow = PopupWindow(popupWindowView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        mPopupWindow!!.inputMethodMode = PopupWindow.INPUT_METHOD_NEEDED
        mPopupWindow!!.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        mPopupWindow!!.isFocusable = true
        mPopupWindow!!.setBackgroundDrawable(BitmapDrawable())
        //添加pop窗口关闭事件
        mPopupWindow!!.setOnDismissListener { backgroundAlpha(1f, window) }
        mPopupWindow!!.animationStyle = R.style.MyPopupWindow_anim_style

        val btnMan = popupWindowView.findViewById<Button>(R.id.btn_man)
        val btnWoman = popupWindowView.findViewById<Button>(R.id.btn_woman)
        val btnCancel = popupWindowView.findViewById<Button>(R.id.btn_cancel)

        btnMan.setOnClickListener {
            if (mOnGenderResultListener != null) {
                mOnGenderResultListener!!.onGenderResult("男")
                mPopupWindow!!.dismiss()
            }
        }
        btnWoman.setOnClickListener {
            if (mOnGenderResultListener != null) {
                mOnGenderResultListener!!.onGenderResult("女")
                mPopupWindow!!.dismiss()
            }
        }
        btnCancel.setOnClickListener { mPopupWindow!!.dismiss() }

        mPopupWindow!!.showAtLocation(inflate(mContext, R.layout.activity_main, null), Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
        backgroundAlpha(0.5f, window)
        return mPopupWindow!!
    }


    private fun backgroundAlpha(bgAlpha: Float, window: Window) {
        val lp = window.attributes
        lp.alpha = bgAlpha //0.0-1.0
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.attributes = lp
    }


    internal var mOnGenderResultListener: OnGenderResultListener? = null

    fun setOnGenderResultListener(onGenderResultListener: OnGenderResultListener) {
        mOnGenderResultListener = onGenderResultListener
    }

    interface OnGenderResultListener {

        fun onGenderResult(string: String)
    }


}
