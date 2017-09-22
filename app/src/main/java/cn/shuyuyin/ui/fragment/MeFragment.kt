package cn.shuyuyin.ui.fragment

import android.content.Intent
import android.content.IntentFilter
import cn.shuyuyin.R
import cn.shuyuyin.common.broadcast.ChangeBackgroundBroadcast
import cn.shuyuyin.ui.activity.*
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * Created by wz on 17-9-7.
 * 我--模块
 */

class MeFragment: BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_me
    }


    override fun initListener() {
        super.initListener()

        //编辑资料
        tv_edit_information.setOnClickListener {

            val intent = Intent()
            intent.setClass(mContext, EditInformationActivity::class.java)
            startActivity(intent)
//            ActivityUtil.startActivityForResult(activity,EditInformationActivity::class.java,)

        }

        //我的消息
        tv_my_message.setOnClickListener { startActivity(Intent(mContext, MyMessageActivity::class.java)) }

        //我的话题
        tv_my_topic.setOnClickListener { startActivity(Intent(mContext, MyTopicActivity::class.java)) }

        //我关注的
        tv_my_follow.setOnClickListener { startActivity(Intent(mContext, MyFollowActivity::class.java)) }

        //成为作者
        tv_become_author.setOnClickListener { startActivity(Intent(mContext, BecomeAuthorActivity::class.java)) }

        //我的歌单
        tv_song_sheet.setOnClickListener { startActivity(Intent(mContext, MySongSheetActivity::class.java)) }

        //我的积分
        tv_my_integral.setOnClickListener {  startActivity(Intent(mContext, MyIntegralActivity::class.java))  }

        //系统设置
        tv_system_setting.setOnClickListener {  startActivity(Intent(mContext, SystemSettingActivity::class.java))  }

        //商城
        iv_shopping_cart.setOnClickListener { startActivity(Intent(mContext, ShoppingMallActivity::class.java)) }

        //我的订单
        tv_my_order.setOnClickListener {
            val intent = Intent(mContext,MyOrderActivity::class.java)
            intent.putExtra("type",0)
            startActivity(intent)
        }

        //待付款
        tv_payment.setOnClickListener {
            val intent = Intent(mContext,MyOrderActivity::class.java)
            intent.putExtra("type",1)
            startActivity(intent)
        }


        //待发货
        tv_send_goods.setOnClickListener {
            val intent = Intent(mContext,MyOrderActivity::class.java)
            intent.putExtra("type",2)
            startActivity(intent)
        }


        //待收货
        tv_wait_goods.setOnClickListener {
            val intent = Intent(mContext,MyOrderActivity::class.java)
            intent.putExtra("type",3)
            startActivity(intent)
        }

        //售后
        tv_after_sale.setOnClickListener {
            val intent = Intent(mContext,MyOrderActivity::class.java)
            intent.putExtra("type",4)
            startActivity(intent)
        }
    }


    override fun init() {
        super.init()

        //实例化IntentFilter对象
        val  filter =  IntentFilter()
        filter.addAction("cn.shuyuyin.action.CHANGE_BACKGROUND")
        val broadcast = ChangeBackgroundBroadcast(iv_background)
        activity.registerReceiver(broadcast,filter)

    }

    override fun initData() {

    }
}

