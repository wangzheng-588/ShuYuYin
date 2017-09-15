package cn.shuyuyin.ui.activity

import android.support.v4.app.Fragment
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.FragmentAdapter
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.AfterSaleFragment
import cn.shuyuyin.ui.fragment.PaymentFragment
import cn.shuyuyin.ui.fragment.SendGoodsFragment
import cn.shuyuyin.ui.fragment.WaitGoodsFragment
import kotlinx.android.synthetic.main.activity_my_order.*

/**
 * Created by wz on 17-9-15.
 *  我的订单
 */
class MyOrderActivity:BaseActivity() {




    private val mTitles = ArrayList<String>()
    private val mFragments = ArrayList<Fragment>()

    override fun setLayoutView(): Int {
        return R.layout.activity_my_order
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

        mTitles.add("待付款")
        mTitles.add("待发货")
        mTitles.add("待收货")
        mTitles.add("售后")


        mFragments.add(PaymentFragment())
        mFragments.add(SendGoodsFragment())
        mFragments.add(WaitGoodsFragment())
        mFragments.add(AfterSaleFragment())


        val adapter = FragmentAdapter(supportFragmentManager, mTitles, mFragments)
        view_pager.offscreenPageLimit = mTitles.size
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

        when (type){
            1->{
                view_pager.currentItem = 0
            }
            2->{
                view_pager.currentItem = 1
            }
            3->{
                view_pager.currentItem = 2
            }
            4->{
                view_pager.currentItem = 3
            }
        }

    }
}