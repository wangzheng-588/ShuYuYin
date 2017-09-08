package cn.shuyuyin.ui.activity

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.PersonalMusicFragment
import cn.shuyuyin.ui.fragment.PersonalTopicFragment
import cn.shuyuyin.ui.fragment.PersonalWenZhangFragment
import kotlinx.android.synthetic.main.activity_personal_homepager.*
import java.nio.file.Files.size



/**
 * Created by wz on 17-9-8.
 */
class PersonalHomepageActivity :BaseActivity() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()


    override fun setLayoutView(): Int {
        return R.layout.activity_personal_homepager
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { v-> finish()}
    }


    override fun init() {

        mTitles.add("文章")
        mTitles.add("话题")
        mTitles.add("音乐")


        mFragments.add(PersonalWenZhangFragment())
        mFragments.add(PersonalTopicFragment())
        mFragments.add(PersonalMusicFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)


    }
}