package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import cn.shuyuyin.R
import cn.shuyuyin.bean.PersonalMusicBean
import cn.shuyuyin.ui.adapter.PersonalMusicAdapter
import cn.shuyuyin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_personal_music.*

/**
 * Created by wz on 17-9-8.
 * 个人音乐
 */
class PersonalMusicFragment:BaseFragment() {
    override fun setLayoutResID(): Int {
        return R.layout.fragment_personal_music
    }

    override fun initData() {

        val personalMusicList = ArrayList<PersonalMusicBean>()

        for (i in 1..100){
            personalMusicList.add(PersonalMusicBean(i))
        }

        recycler_view.adapter = PersonalMusicAdapter(data = personalMusicList)
        recycler_view.layoutManager = LinearLayoutManager(mContext)

    }
}