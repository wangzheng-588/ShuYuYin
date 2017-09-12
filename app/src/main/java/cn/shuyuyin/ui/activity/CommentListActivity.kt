package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.CommentBean
import cn.shuyuyin.ui.adapter.CommentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_comment_list.*

/**
 * Created by wz on 17-9-12.
 * 评论列表
 */
class CommentListActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_comment_list
    }


    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

    }
    override fun init() {

        val commentList = ArrayList<CommentBean>()
        for (i in 1..100){
            commentList.add(CommentBean(i))
        }

        recycler_view.adapter = CommentAdapter(data = commentList)
        recycler_view.layoutManager = LinearLayoutManager(this)

    }
}