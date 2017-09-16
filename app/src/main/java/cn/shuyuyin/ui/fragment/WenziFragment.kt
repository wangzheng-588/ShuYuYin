package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import cn.shuyuyin.R
import cn.shuyuyin.presenter.MainInfoPresenter
import cn.shuyuyin.presenter.contract.MainInfoContract
import cn.shuyuyin.ui.adapter.HomeWenZiAdapter
import kotlinx.android.synthetic.main.fragment_wenzi.*

/**
 * Created by wz on 17-9-7.
 */

class WenziFragment: ProgressFragment<MainInfoPresenter>(),MainInfoContract.WenziView {


    override fun setLayout(): Int {
        return R.layout.fragment_wenzi
    }

    override fun init() {

        recycler_view_wenzi.layoutManager = LinearLayoutManager(mContext)
        recycler_view_wenzi.adapter = HomeWenZiAdapter(mContext)
    }

    override fun initData() {
        super.initData()


        mPresenter = MainInfoPresenter(view = this)
        mPresenter!!.getWenziData()
    }

    override fun initRealContentView(realContentView: View) {
    }



    override fun showResult() {

        Log.e("靶标 ","fdkfsdf")
    }


}
