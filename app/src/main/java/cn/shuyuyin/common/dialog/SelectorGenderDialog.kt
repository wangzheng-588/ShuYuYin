package cn.shuyuyin.common.dialog

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.BitmapCompressor.getBitmapFormUri
import cn.shuyuyin.common.utils.Config
import cn.shuyuyin.ui.view.crop.dialog.BaseDialog
import java.io.FileNotFoundException
import java.io.IOException

/**
 * Created by wz on 17-9-11.
 */
class SelectorGenderDialog(context: Context, val activity: Activity) : BaseDialog(context) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_choice_gender_layout)

        val btnMan = findViewById<Button>(R.id.btn_man)
        val btnWoman = findViewById<Button>(R.id.btn_woman)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)


        btnMan.setOnClickListener {
            val intent = Intent()
            intent.putExtra(Config.INFOMATION_GENDER, "男")
            activity.setResult(Config.INFOMATION_GENDER_REQUEST_CODE,intent)
            this@SelectorGenderDialog.dismiss()
        }

        btnWoman.setOnClickListener {
            val intent = Intent()
            intent.putExtra(Config.INFOMATION_GENDER, "女")
            activity.setResult(Config.INFOMATION_GENDER_REQUEST_CODE,intent)
            this@SelectorGenderDialog.dismiss()
        }

        btnCancel.setOnClickListener { this@SelectorGenderDialog.dismiss() }

    }


     var onGenderResultListener: OnGenderResultListener? = null


    fun setOnPhotoResultListener(onGenderResultListener: OnGenderResultListener) {
        this@SelectorGenderDialog.onGenderResultListener = onGenderResultListener
    }

    interface OnGenderResultListener {
        fun onGenderResult(string: String)
    }


}