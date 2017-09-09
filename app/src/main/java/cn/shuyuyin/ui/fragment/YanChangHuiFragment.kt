package cn.shuyuyin.ui.fragment

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_yanchanghui.*

/**
 * Created by wz on 17-9-7.
 */
class YanChangHuiFragment: BaseFragment() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()



    override fun setLayoutResID(): Int {
        return R.layout.fragment_yanchanghui
    }


    override fun init() {
        super.init()

        mTitles.add("活动")
        mTitles.add("场地")



        mFragments.add(YanChangHuiActivityFragment())
        mFragments.add(YanChangHuiChangDiFragment())

        val adapter = FragmentAdapter(childFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }

    override fun initData() {
    }
}