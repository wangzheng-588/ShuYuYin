package cn.shuyuyin.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cn.shuyuyin.R
import cn.shuyuyin.bean.HomeMoreBean
import cn.shuyuyin.bean.TopicBean
import cn.shuyuyin.ui.activity.MusicListenerDetailActivity
import java.util.*

/**
 * Created by wz on 17-7-9.
 * 文字 adapter
 */

class MusicListenAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /**
     * 当前类型
     */
    var currentType = MUSIC_TYPE


    private val inflater: LayoutInflater = LayoutInflater.from(mContext)


    /**
     * 根据位置得到当前是什么类型

     * @param position
     * *
     * @return
     */
    override fun getItemViewType(position: Int): Int {
        currentType = if (position == MUSIC_TYPE) {
            MUSIC_TYPE
        } else {
            MORE
        }
        return currentType
    }


    override fun getItemCount(): Int {
        return 1+5
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        if (viewType == MUSIC_TYPE) {
            return MusicTypeViewHolder(mContext, inflater.inflate(R.layout.music_type_layout, null))
        } else if (viewType == MORE) {
            return MoreViewHolder(mContext, inflater.inflate(R.layout.item_music_listener_more, parent, false))
        }

        return null
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == MUSIC_TYPE) {

            val musicTypeViewHolder = holder as MusicTypeViewHolder
            musicTypeViewHolder.setData()

        } else if (getItemViewType(position) == MORE) {
            val moreViewHolder = holder as MoreViewHolder
            moreViewHolder.setData()
        }

    }



    internal inner class MusicTypeViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view_topic)
        private val imageIDs = ArrayList<TopicBean>()

        fun setData() {


            (1..100).mapTo(imageIDs){ TopicBean(R.mipmap.default_image) }

            val adapter =  MusicTypeAdapter(data = imageIDs)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)

            adapter.setOnItemClickListener { adapter, view, position ->
                mContext.startActivity(Intent(mContext, MusicListenerDetailActivity::class.java))
            }


        }
    }

    internal inner class MoreViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val homeMoreList = ArrayList<HomeMoreBean>()



        fun setData() {
            for (i in 1..100){
                homeMoreList.add(HomeMoreBean(R.mipmap.default_image))
            }

            this.itemView.setOnClickListener {
                Toast.makeText(mContext, "jfdsfa", Toast.LENGTH_SHORT).show()
            }

        }


    }

    companion object {


        /**
         * 二种类型
         */

        /**
         * 音乐类型
         */
        val MUSIC_TYPE =0

        /**
         * 更多
         */
        val MORE = 2
    }


}