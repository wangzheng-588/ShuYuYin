package cn.shuyuyin.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.PopupWindowUtil
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.view.crop.dialog.PickPhotoDialog
import kotlinx.android.synthetic.main.activity_edit_infomation.*


/**
 * Created by wz on 17-9-11.
 */
class EditInformationActivity:BaseActivity() {

    var pickPhotoDialog:PickPhotoDialog?= null
    var popWindowUtils:PopupWindowUtil?=null

    override fun setLayoutView(): Int {
        return R.layout.activity_edit_infomation
    }

    override fun initView() {
        super.initView()
        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        pickPhotoDialog = PickPhotoDialog(this,this)
        popWindowUtils = PopupWindowUtil(this)


        pickPhotoDialog!!.setOnPhotoResultListener(object:PickPhotoDialog.OnPhotoResultListener{
            override fun onCameraResult(path: String?) {

            }

            override fun onCutPhotoResult(bitmap: Bitmap?) {
                if (bitmap!=null){
                    civ_head.setImageBitmap(bitmap)
                }
            }

            override fun onPhotoResult(selectedImgs: Uri?) {

            }

        })

        tv_change_head.setOnClickListener {
            pickPhotoDialog!!.show()
        }

        ll_gender.setOnClickListener {

            popWindowUtils!!.showGenderBottomPopWindow(window)


        }

        popWindowUtils!!.setOnGenderResultListener(object: PopupWindowUtil.OnGenderResultListener {
            override fun onGenderResult(string: String) {
                tv_gender.text = string
            }
        })


        ib_back.setOnClickListener { finish() }



    }

    override fun init() {

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (pickPhotoDialog != null) {
            pickPhotoDialog!!.onActivityResult(requestCode, resultCode, data)
        }

    }


}