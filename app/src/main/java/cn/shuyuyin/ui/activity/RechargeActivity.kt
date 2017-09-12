package cn.shuyuyin.ui.activity

import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_recharge.*

/**
 * Created by wz on 17-9-12.
 * 充值
 */
class RechargeActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_recharge
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