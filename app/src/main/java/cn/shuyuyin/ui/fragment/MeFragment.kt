package cn.shuyuyin.ui.fragment

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.activity.EditInformationActivity
import cn.shuyuyin.ui.activity.MyFollowActivity
import cn.shuyuyin.ui.activity.MyMessageActivity
import cn.shuyuyin.ui.activity.MyTopicActivity
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

        //我的消息
        tv_my_message.setOnClickListener { startActivity(Intent(mContext, MyMessageActivity::class.java)) }

        //我的话题
        tv_my_topic.setOnClickListener { startActivity(Intent(mContext, MyTopicActivity::class.java)) }

        //我关注的
        tv_my_follow.setOnClickListener { startActivity(Intent(mContext, MyFollowActivity::class.java)) }

    }

    override fun initData() {

    }
}
