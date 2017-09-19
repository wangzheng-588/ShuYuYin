package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.SearchMusicBean
import cn.shuyuyin.ui.adapter.SearchMusicAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_music.*

/**
 * Created by wz on 17-9-19.
 * 搜索音乐
 */
class SearchMusicFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_search_music
    }

    override fun initData() {

        val list = ArrayList<SearchMusicBean>()

        (1..100).mapTo(list){ SearchMusicBean(it) }

        recycler_view_search_music.adapter = SearchMusicAdapter(data = list)
        recycler_view_search_music.layoutManager = LinearLayoutManager(mContext)

    }
}