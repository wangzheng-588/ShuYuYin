package cn.shuyuyin.ui.activity

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.SearchGoodsFragment
import cn.shuyuyin.ui.fragment.SearchMusicFragment
import cn.shuyuyin.ui.fragment.SearchTopicFragment
import cn.shuyuyin.ui.fragment.SearchWenzhangFragment
import kotlinx.android.synthetic.main.activity_serarch.*

/**
 * Created by wz on 17-9-19.
 * 搜索
 */
class SearchActivityActivity:BaseActivity() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()


    override fun setLayoutView(): Int {
        return R.layout.activity_serarch
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }
    }


    override fun init() {


        mTitles.add("文章")
        mTitles.add("话题")
        mTitles.add("音乐")
        mTitles.add("商品")


        mFragments.add(SearchWenzhangFragment())
        mFragments.add(SearchTopicFragment())
        mFragments.add(SearchMusicFragment())
        mFragments.add(SearchGoodsFragment())



        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }
}