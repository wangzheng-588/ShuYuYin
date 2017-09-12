package cn.shuyuyin.ui.fragment

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.activity.EditInformationActivity
import cn.shuyuyin.ui.activity.MyMessageActivity
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * Created by wz on 17-9-7.
 * 我--模块
 */

class MeFragment: BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_me
    }


    override fun initListener() {
        super.initListener()

        tv_edit_information.setOnClickListener {

            val intent = Intent()
            intent.setClass(mContext, EditInformationActivity::class.java)
            startActivity(intent)

        }

        tv_my_message.setOnClickListener { startActivity(Intent(mContext, MyMessageActivity::class.java)) }

    }

    override fun initData() {

    }
}
