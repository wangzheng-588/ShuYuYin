package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_switch_address.*

/**
 * Created by wz on 17-9-15.
 * 选择收货地址
 */
class SwitchAddressActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_switch_address
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

        tv_add_address.setOnClickListener { startActivity(Intent(this,AddAddressActivity::class.java)) }
    }

    override fun init() {



    }
}