package cn.shuyuyin.ui.activity

import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_bind_account.*

/**
 * Created by wz on 17-9-12.
 * 绑定第三方帐号
 */
class BindAccountActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_bind_account
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }


    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

    }
}