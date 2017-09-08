package cn.shuyuyin.ui.activity

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_topic.*

/**
 * Created by wz on 17-9-8.
 */
class TopicActivity: BaseActivity() {


    override fun setLayoutView(): Int {
        return R.layout.activity_topic
    }


    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true

    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { v->

            finish()

        }

        ll_comment.setOnClickListener{ v->

            val intent = Intent()
            intent.setClass(this,CommentActivity::class.java)
            startActivity(intent)
        }

    }

    override fun init() {


    }
}