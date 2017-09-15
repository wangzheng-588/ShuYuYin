package cn.shuyuyin.ui.activity

import cn.shuyuyin.R
import cn.shuyuyin.common.utils.ShareUtils
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_mall_activity_detail.*

/**
 * Created by wz on 17-9-15.
 * 商城活动详情
 */
class MallActivityDetailActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_mall_activity_detail
    }


    override fun initView() {
        super.initView()

    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish() }

        ib_share.setOnClickListener { ShareUtils.showShare(this) }
    }

    override fun init() {

    }
}