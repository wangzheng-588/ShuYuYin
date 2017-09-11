package cn.shuyuyin.ui.activity

import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_reg.*

/**
 * Created by wz on 17-9-11.
 * 注册
 */
class RegActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_reg
    }

    override fun initListener() {
        super.initListener()

        iv_back.setOnClickListener { finish() }
    }

    override fun init() {

    }
}