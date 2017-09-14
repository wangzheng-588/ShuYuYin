package cn.shuyuyin.ui.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import cn.shuyuyin.R
import cn.shuyuyin.bean.ArtistsBean
import cn.shuyuyin.ui.adapter.ArtistsAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_artists.*

/**
 * Created by wz on 17-9-14.
 * 艺人
 */
class ArtistsFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_artists
    }

    override fun initData() {

        val artistsList = ArrayList<ArtistsBean>()

        for (i in 1..100){
            artistsList.add(ArtistsBean(i))
        }


        recycler_view.adapter = ArtistsAdapter(data = artistsList)

        recycler_view.layoutManager = GridLayoutManager(mContext,3,RecyclerView.VERTICAL,false)

    }
}