package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.CommentBean
import cn.shuyuyin.ui.adapter.CommentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_comment.*

/**
 * Created by wz on 17-9-8.
 */
class CommentActivity: BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_comment
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
    }

    override fun init() {

        val commentLists = ArrayList<CommentBean>()
        for (i in 1..100){
            commentLists.add(CommentBean(i))
        }

        recycler_view_comment.adapter = CommentAdapter(data = commentLists )
        recycler_view_comment.layoutManager = LinearLayoutManager(this)
    }


}