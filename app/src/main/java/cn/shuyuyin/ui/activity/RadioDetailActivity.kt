package cn.shuyuyin.ui.activity

import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_radio_detail.*

/**
 * Created by wz on 17-9-14.
 * 电台详情
 */
class RadioDetailActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_radio_detail
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

    }
}