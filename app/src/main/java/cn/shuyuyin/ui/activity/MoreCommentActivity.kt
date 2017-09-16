package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.CommentBean
import cn.shuyuyin.ui.adapter.CommentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_more_comment.*

/**
 * Created by wz on 17-9-9.
 * 更多评论
 */
class MoreCommentActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_more_comment
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }

    override fun init() {

        val moreCommentList = ArrayList<CommentBean>()

        for (i in 1..100){
            moreCommentList.add(CommentBean(i))
        }
//        recycler_view.adapter = MoreCommentAdapter(data=moreCommentList)
        recycler_view.adapter = CommentAdapter(data=moreCommentList)

        recycler_view.layoutManager = LinearLayoutManager(this)

    }
}