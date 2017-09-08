package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import cn.shuyuyin.R
import cn.shuyuyin.bean.DaShangListBean
import cn.shuyuyin.ui.adapter.DaShangAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dashang.*

/**
 * Created by wz on 17-9-8.
 * 打赏activity
 */
class DaShangActivity:BaseActivity() {
    override fun setLayoutView(): Int {
        return R.layout.activity_dashang
    }



    override fun initView() {
        super.initView()
        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { v->
            finish()
        }

        iv_dashang_list_enter.setOnClickListener{ v->

            val intent = Intent()
            intent.setClass(this,DaShangListActivity::class.java)
            startActivity(intent)
        }
    }


    override fun init() {

        val daShangList = ArrayList<DaShangListBean>()
        for (i in 1..100){
            daShangList.add(DaShangListBean(i))
        }
        recycler_view.adapter = DaShangAdapter(data = daShangList)
        recycler_view.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)

    }
}