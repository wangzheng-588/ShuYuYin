package cn.shuyuyin.ui.activity

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.CategoryRecommendFragment
import cn.shuyuyin.ui.fragment.RecommendActivityFragment
import cn.shuyuyin.ui.fragment.RecommendCategoryFragment
import kotlinx.android.synthetic.main.activity_recommend_detail.*

/**
 * Created by wz on 17-9-14.
 * 商城推荐模块
 */

class RecommendDetailActivity:BaseActivity() {



    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()

    override fun setLayoutView(): Int {
        return R.layout.activity_recommend_detail
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

        val type = intent.getIntExtra("type",0)

        mTitles.add("推荐")
        mTitles.add("分类")
        mTitles.add("活动")


        mFragments.add(CategoryRecommendFragment())
        mFragments.add(RecommendCategoryFragment())
        mFragments.add(RecommendActivityFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

        when (type){
            0->{
                view_pager.currentItem = 0
            }
            1->{
                view_pager.currentItem = 1
            }
            2->{

            }
        }

    }
}