package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.MusicListenAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_music_listen.*

/**
 * Created by wz on 17-9-14.
 * 乐听
 */
class MusicListenFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_music_listen
    }


    override fun initData() {

        recycler_view.layoutManager = LinearLayoutManager(mContext)
        recycler_view.adapter = MusicListenAdapter(mContext)

    }
}