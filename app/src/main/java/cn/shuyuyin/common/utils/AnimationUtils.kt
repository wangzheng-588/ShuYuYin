package cn.shuyuyin.common.utils

import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * Created by wz on 2017/2/11.
 */

object AnimationUtils {

    /**
     * 旋转动画
     */
    fun RotatesAnim(context: Context, view: View, animId: Int) {
        val animation = android.view.animation.AnimationUtils.loadAnimation(context, animId)
        val lin = LinearInterpolator()//设置动画匀速运动
        animation.interpolator = lin
        view.startAnimation(animation)
    }

    /**
     * 结束动画
     */
    fun stopAnim(view: View) {
        view.clearAnimation()
    }
}
