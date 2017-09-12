package cn.shuyuyin.ui.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.PopupWindowUtil
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.view.crop.dialog.PickPhotoDialog
import kotlinx.android.synthetic.main.activity_edit_infomation.*




/**
 * Created by wz on 17-9-11.
 * 编辑资料
 */
class EditInformationActivity:BaseActivity() {

    val CHANGE_BACKGROUND:Int = 0
    val CHANGE_HEAD_IMAGE:Int = 1
    var CURRENT_CHANGE_STAGE = CHANGE_HEAD_IMAGE

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

                    when (CURRENT_CHANGE_STAGE){
                        CHANGE_BACKGROUND->{
                            val bd = BitmapDrawable(resources, bitmap)
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                ll_background.background =bd
                            }
                        }
                        CHANGE_HEAD_IMAGE->{
                            civ_head.setImageBitmap(bitmap)
                        }
                    }


                }
            }

            override fun onPhotoResult(selectedImgs: Uri?) {

            }

        })

        tv_change_head.setOnClickListener {
            CURRENT_CHANGE_STAGE = CHANGE_HEAD_IMAGE
            pickPhotoDialog!!.show()
        }


        ll_change_background.setOnClickListener {
            CURRENT_CHANGE_STAGE = CHANGE_BACKGROUND
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

        ll_change_phone_num.setOnClickListener {

            val intent = Intent()
            intent.setClass(this,ChangePhoneNumActivity::class.java)
            startActivity(intent)

        }


        //修改密码
        ll_change_password.setOnClickListener {
            startActivity(Intent(this,ChangePasswordActivity::class.java))
        }

        //修改支付密码
        ll_change_pay_password.setOnClickListener { startActivity(Intent(this,ChangePayPasswordActivity::class.java)) }

        //绑定第三方帐号
        ll_bind_account.setOnClickListener {startActivity(Intent(this,BindAccountActivity::class.java)) }
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