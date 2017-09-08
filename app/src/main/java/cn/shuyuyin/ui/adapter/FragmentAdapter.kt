package cn.shuyuyin.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by wz on 17-7-6.
 */

class FragmentAdapter(fm: FragmentManager, private val mTitles: List<String>, private val mFragments: List<Fragment>?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mFragments!![position]
    }

    override fun getCount(): Int {
        return mFragments?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }


}
