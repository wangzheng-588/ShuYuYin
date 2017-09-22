package cn.shuyuyin.ui.fragment

import android.content.Intent
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.ShareUtils
import cn.shuyuyin.ui.activity.CommentActivity
import cn.shuyuyin.ui.activity.DaShangActivity
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

    override fun initListener() {
        super.initListener()

        //打赏
        iv_dashang.setOnClickListener {
            startActivity(Intent(activity,DaShangActivity::class.java))
        }

        //评论
        iv_comment.setOnClickListener {
            startActivity(Intent(activity,CommentActivity::class.java))
        }

        //分享
        iv_share.setOnClickListener {
            ShareUtils.showShare(mContext)
        }

    }

    override fun initData() {
    }
}