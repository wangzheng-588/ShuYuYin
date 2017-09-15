package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_confirm_order.*

/**
 * Created by wz on 17-9-15.
 * 确认订单
 */
class ConfirmOrderActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_confirm_order
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()


        ib_back.setOnClickListener { finish() }

        tv_switch_address.setOnClickListener {

            startActivity(Intent(this,SwitchAddressActivity::class.java))
        }

        tv_submit_order.setOnClickListener { startActivity(Intent(this,SubmitOrderActivity::class.java)) }
    }

    override fun init() {

    }
}