package cn.shuyuyin.common.extends

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast
import cn.shuyuyin.common.utils.ToastUtils

/**
 * Created by wz on 17-9-8.
 */


fun Fragment.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(getActivity(), message, duration).show()
}

fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
