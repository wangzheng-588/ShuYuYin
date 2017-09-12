package cn.shuyuyin.ui.activity

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.MyFollowForumFragment
import cn.shuyuyin.ui.fragment.MyFollowPeopleFragment
import cn.shuyuyin.ui.fragment.MyFollowWenZhangFragment
import kotlinx.android.synthetic.main.activity_my_follow.*

/**
 * Created by wz on 17-9-12.
 * 我关注的
 */

class MyFollowActivity:BaseActivity() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()

    override fun setLayoutView(): Int {
        return R.layout.activity_my_follow
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

        mTitles.add("文章")
        mTitles.add("论坛")
        mTitles.add("人")


        mFragments.add(MyFollowWenZhangFragment())
        mFragments.add(MyFollowForumFragment())
        mFragments.add(MyFollowPeopleFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }
}