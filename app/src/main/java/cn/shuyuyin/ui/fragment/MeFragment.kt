package cn.shuyuyin.ui.fragment

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.activity.*
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

        //成为作者
        tv_become_author.setOnClickListener { startActivity(Intent(mContext, BecomeAuthorActivity::class.java)) }

        //我的歌单
        tv_song_sheet.setOnClickListener { startActivity(Intent(mContext, MySongSheetActivity::class.java)) }

        //我的积分
        tv_my_integral.setOnClickListener {  startActivity(Intent(mContext, MyIntegralActivity::class.java))  }

        //系统设置
        tv_system_setting.setOnClickListener {  startActivity(Intent(mContext, SystemSettingActivity::class.java))  }



    }

    override fun initData() {

    }
}

