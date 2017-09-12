package cn.shuyuyin.ui.activity

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.DraftsFragment
import cn.shuyuyin.ui.fragment.InAuditFragment
import cn.shuyuyin.ui.fragment.PublishedFragment
import kotlinx.android.synthetic.main.activity_my_topic.*

/**
 * Created by wz on 17-9-12.
 * 我的话题
 */
class MyTopicActivity:BaseActivity() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()

    override fun setLayoutView(): Int {
        return R.layout.activity_my_topic
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

        mTitles.add("审核中")
        mTitles.add("已发布")
        mTitles.add("草稿箱")


        mFragments.add(InAuditFragment())
        mFragments.add(PublishedFragment())
        mFragments.add(DraftsFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)


    }
}