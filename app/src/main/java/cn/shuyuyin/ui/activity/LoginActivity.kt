package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.common.AppManager
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by wz on 17-9-11.
 * 登录
 */
class LoginActivity:BaseActivity() {



    override fun setLayoutView(): Int {
        return R.layout.activity_login
    }


    override fun initListener() {
        super.initListener()

        iv_close.setOnClickListener { finish() }


        btn_login.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        tv_forget_password.setOnClickListener {
            startActivity(Intent(this,ForgetPasswordActivity::class.java))
            AppManager.appManager.addActivity(this)
        }

        tv_reg.setOnClickListener {
            startActivity(Intent(this,RegActivity::class.java))
            AppManager.appManager.addActivity(this)
        }
    }


    override fun init() {

    }
}