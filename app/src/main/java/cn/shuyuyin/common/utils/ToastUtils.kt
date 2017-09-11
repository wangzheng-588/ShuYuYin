package cn.shuyuyin.common.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by wz on 17-9-11.
 */

object ToastUtils {

    private var mToast: Toast? = null

    fun show(context: Context, text: String) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
        } else {
            mToast!!.setText(text)
        }

        mToast!!.show()
    }
}
