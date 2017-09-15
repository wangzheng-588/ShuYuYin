package cn.shuyuyin.ui.fragment

import android.widget.LinearLayout
import cn.shuyuyin.R
import cn.shuyuyin.bean.Goods
import cn.shuyuyin.bean.OrderItemBean
import cn.shuyuyin.ui.base.BaseFragment
import cn.shuyuyin.ui.view.SendGoodsOrderListview
import kotlinx.android.synthetic.main.fragment_send_goods.*
import java.util.*

/**
 * Created by wz on 17-9-15.
 * 待发货
 */
class SendGoodsFragment:BaseFragment() {


    private val orders = ArrayList<OrderItemBean>()


    override fun setLayoutResID(): Int {
        return R.layout.fragment_send_goods
    }

    override fun initData() {

        getdata()
        initListview()

    }

    private fun initListview() {
        for (order in orders) {
            val orderListview = SendGoodsOrderListview(mContext)
            orderListview.setData(order)
            //act_ungive_content.addView(orderListview);
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(0, 15, 0, 0)
            ll_allorder.addView(orderListview, params)
        }
    }

    private fun getdata() {
        val good1 = Goods()
        good1.setProductTitle("苹果")
        good1.setProductCategory("玻璃")
        good1.setProductSpecification(17.8)
        good1.setProductPrice(25)
        good1.setProductCount(3)

        val good2 = Goods()
        good2.setProductTitle("巧克力")
        good2.setProductCategory("哇哈哈")
        good2.setProductSpecification(17.8)
        good2.setProductPrice(2)
        good2.setProductCount(2)

        val good3 = Goods()
        good3.setProductTitle("橘子")
        good3.setProductCategory("小火箭")
        good3.setProductSpecification(17.9)
        good3.setProductPrice(20)
        good3.setProductCount(5)

        val goods = ArrayList<Goods>()
        goods.add(good1)
        goods.add(good2)
        goods.add(good3)

        val goods1 = ArrayList<Goods>()
        goods1.add(good1)
        goods1.add(good3)

        val orderItemBean = OrderItemBean()
        orderItemBean.list = goods
        orderItemBean.orderState = 0
        orderItemBean.time = "123456789"
        orderItemBean.totalPrice = 300

        val orderItemBean1 = OrderItemBean()
        orderItemBean1.list = goods1
        orderItemBean1.orderState = 0
        orderItemBean1.time = "4567846415"
        orderItemBean1.totalPrice = 500

        val orderslist = ArrayList<OrderItemBean>()
        orderslist.add(orderItemBean)
        orderslist.add(orderItemBean1)
        orders.addAll(orderslist)
    }
}