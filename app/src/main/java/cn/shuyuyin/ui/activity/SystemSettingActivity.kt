package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_system_setting.*

/**
 * Created by wz on 17-9-12.
 * 系统设置
 */
class SystemSettingActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_system_setting
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

        //帮助中心
        tv_help_center.setOnClickListener { startActivity(Intent(this,HelpCenterActivity::class.java)) }

        //联系客服
        tv_contact_service.setOnClickListener { startActivity(Intent(this,ContactServiceActivity::class.java)) }

        //关于我们
        tv_about_me.setOnClickListener { startActivity(Intent(this,AboutMeActivity::class.java)) }

        //清理缓存
        tv_clear_cache.setOnClickListener {  }
    }

    override fun init() {

    }
}