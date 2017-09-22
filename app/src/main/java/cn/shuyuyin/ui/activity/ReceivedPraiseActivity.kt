package cn.shuyuyin.ui.activity

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.ReceivedPraiseBean
import cn.shuyuyin.ui.adapter.RecyclerPraiseAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_received_praise.*

/**
 * Created by wz on 17-9-22.
 * 收到的赞
 */
class ReceivedPraiseActivity :BaseActivity(){
    override fun setLayoutView(): Int {
        return R.layout.activity_received_praise
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


        val list = ArrayList<ReceivedPraiseBean>()

        (1..100).mapTo(list){ ReceivedPraiseBean(it) }

        recycler_view.adapter = RecyclerPraiseAdapter(data = list)
        recycler_view.layoutManager = LinearLayoutManager(this)

    }
}