package cn.shuyuyin.ui.activity

import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_submit_order.*

/**
 * Created by wz on 17-9-15.
 * 提交订单
 */
class SubmitOrderActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_submit_order
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
        tv_total.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

    }
}