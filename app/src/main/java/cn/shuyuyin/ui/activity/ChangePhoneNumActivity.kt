package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_change_phone_num.*

/**
 * Created by wz on 17-9-12.
 * 修改手机号码
 */
class ChangePhoneNumActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_change_phone_num
    }

    override fun initView() {
        super.initView()
        tv_title.paint.isFakeBoldText = true
    }


    override fun initListener() {
        super.initListener()

        btn_next.setOnClickListener {
            startActivity(Intent(this,EditNewPhoneNumActivity::class.java))
        }
    }

    override fun init() {

    }
}