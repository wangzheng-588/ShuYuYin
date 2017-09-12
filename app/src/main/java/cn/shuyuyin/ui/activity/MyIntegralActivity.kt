package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.BalanceFragment
import cn.shuyuyin.ui.fragment.IntegralFragment
import kotlinx.android.synthetic.main.activity_my_integral.*

/**
 * Created by wz on 17-9-12.
 * 我的积分
 */
class MyIntegralActivity :BaseActivity() {

    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()


    override fun setLayoutView(): Int {
        return R.layout.activity_my_integral
    }

    override fun initView() {
        super.initView()
        tv_title.paint.isFakeBoldText = true

    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

        tv_recharge.setOnClickListener { startActivity(Intent(this,RechargeActivity::class.java)) }
    }

    override fun init() {


        mTitles.add("积分")
        mTitles.add("余额")


        mFragments.add(IntegralFragment())
        mFragments.add(BalanceFragment())

        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }
}