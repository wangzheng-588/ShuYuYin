package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.ShoppingActivityFragment
import cn.shuyuyin.ui.fragment.ShoppingMallCategoryFragment
import cn.shuyuyin.ui.fragment.ShoppingMallRecommendFragment
import kotlinx.android.synthetic.main.activity_shopping_mall.*

/**
 * Created by wz on 17-9-14.
 * 商城
 */
class ShoppingMallActivity:BaseActivity() {


    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()


    override fun setLayoutView(): Int {
        return R.layout.activity_shopping_mall
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

        ib_search.setOnClickListener { startActivity(Intent(this,MallSearchActivity::class.java)) }
    }

    override fun init() {

        mTitles.add("推荐")
        mTitles.add("分类")
        mTitles.add("活动")


        mFragments.add(ShoppingMallRecommendFragment())
        mFragments.add(ShoppingMallCategoryFragment())
        mFragments.add(ShoppingActivityFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }
}