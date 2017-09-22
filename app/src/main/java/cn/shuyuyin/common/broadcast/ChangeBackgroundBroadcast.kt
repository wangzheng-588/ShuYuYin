package cn.shuyuyin.common.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.view.View
import android.widget.ImageView
import cn.shuyuyin.common.utils.BitmapCompressor

/**
 * Created by wz on 17-9-22.
 * 改变背景广播
 */
class ChangeBackgroundBroadcast(val view: View):BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val imageStrUri = intent!!.getStringExtra("background")
        val uri = Uri.parse(imageStrUri)

        val bitmap = BitmapCompressor.getBitmapFormUri(context,uri)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (view is ImageView){
                view.scaleType = ImageView.ScaleType.CENTER_CROP
                view.background = BitmapDrawable(context!!.resources, bitmap)
            }
        }

    }
}