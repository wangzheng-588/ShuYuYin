package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.DaShangListBean
import cn.shuyuyin.ui.adapter.DaShangListAdapter
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dashang.*

/**
 * Created by wz on 17-9-8.
 * 打赏列表
 */
class DaShangListActivity:BaseActivity() {


    override fun setLayoutView(): Int {
        return R.layout.activity_dashang_list
    }

    override fun initView() {
        super.initView()

        tv_title.paint.isFakeBoldText = true
    }

    override fun initListener() {
        super.initListener()

        ib_back.setOnClickListener { finish()}

    }

    override fun init() {

        val daShangList = ArrayList<DaShangListBean>()
        val daShangAdapter = DaShangListAdapter(data = daShangList)
        for (i in 1..100){
          daShangList.add(DaShangListBean(i))
        }
        recycler_view.adapter = daShangAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        daShangAdapter.setOnItemClickListener { adapter, view, position ->

            val intent = Intent();
            intent.setClass(this, PersonalHomepageActivity::class.java)
            startActivity(intent)

        }

    }
}