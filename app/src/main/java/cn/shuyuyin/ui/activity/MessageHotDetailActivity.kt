package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_message_hot_detail.*

/**
 * Created by wz on 17-9-9.
 * 热门详情
 */
class MessageHotDetailActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_message_hot_detail
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { v->finish() }

        tv_more_comment.setOnClickListener { v->
            val intent = Intent()
            intent.setClass(this,MoreCommentActivity::class.java)
            startActivity(intent)

        }

        ll_message_hot_dashang.setOnClickListener { v->

            val intent = Intent()
            intent.setClass(this,DaShangActivity::class.java)
            startActivity(intent)

        }

    }

    override fun init() {
    }
}