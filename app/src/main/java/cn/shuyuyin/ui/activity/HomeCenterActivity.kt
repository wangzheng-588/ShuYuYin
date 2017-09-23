package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.ArtistsFragment
import cn.shuyuyin.ui.fragment.MusicListenFragment
import cn.shuyuyin.ui.fragment.RadioFragment
import kotlinx.android.synthetic.main.activity_home_center.*


/**
 * Created by wz on 17-9-14.
 * 首页中心模块 -- 电台
 */
class HomeCenterActivity:BaseActivity() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()



    override fun setLayoutView(): Int {
        return R.layout.activity_home_center
    }

    override fun initListener() {
        super.initListener()
        ib_back.setOnClickListener { finish() }
        ib_play.setOnClickListener { startActivity(Intent(this,AudioPlayActivity::class.java)) }
    }







    override fun init() {


        mTitles.add("电台")
        mTitles.add("乐听")
        mTitles.add("艺人")


        mFragments.add(RadioFragment())
        mFragments.add(MusicListenFragment())
        mFragments.add(ArtistsFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)


    }


}


