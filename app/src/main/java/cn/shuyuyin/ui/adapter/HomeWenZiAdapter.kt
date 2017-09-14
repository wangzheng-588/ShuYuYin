package cn.shuyuyin.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import cn.shuyuyin.R
import cn.shuyuyin.bean.HomeMoreBean
import cn.shuyuyin.bean.TopicBean
import cn.shuyuyin.common.utils.GlideImageLoader
import cn.shuyuyin.ui.activity.TopicActivity
import com.youth.banner.Banner
import java.util.*


/**
 * Created by wz on 17-7-9.
 * 文字 adapter
 */

class HomeWenZiAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /**
     * 当前类型
     */
    var currentType = BANNER


    private val inflater: LayoutInflater


    init {
        inflater = LayoutInflater.from(mContext)

    }


    /**
     * 根据位置得到当前是什么类型

     * @param position
     * *
     * @return
     */
    override fun getItemViewType(position: Int): Int {
        if (position == BANNER) {
            currentType = BANNER
        } else if (position == TOPIC) {
            currentType = TOPIC
        } else {
            currentType = MORE
        }
        return currentType
    }


    override fun getItemCount(): Int {
        return 2+80
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        if (viewType == BANNER) {
            return BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null))
        } else if (viewType == TOPIC) {
            return TopicViewHolder(mContext, inflater.inflate(R.layout.topic_layout, null))
        } else if (viewType == MORE) {
            return MoreViewHolder(mContext, inflater.inflate(R.layout.item_home_more, parent, false))
        }

        return null
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == BANNER) {
            val bannerViewHolder = holder as BannerViewHolder
            //设置数据Banner的数据
            bannerViewHolder.setData()
        } else if (getItemViewType(position) == TOPIC) {

            val topicViewHolder = holder as TopicViewHolder
             topicViewHolder.setData()

        } else if (getItemViewType(position) == MORE) {
            val moreViewHolder = holder as MoreViewHolder
            moreViewHolder.setData()
        }

    }


    inner class BannerViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val banner: Banner

        init {
            banner = itemView.findViewById<Banner>(R.id.banner)
        }

        fun setData() {

            val imagesIDs = ArrayList<Int>()
            imagesIDs.add(R.mipmap.default_image)
            imagesIDs.add(R.mipmap.default_image)
            imagesIDs.add(R.mipmap.default_image)


            this.banner.setImages(imagesIDs)
                    .setImageLoader(GlideImageLoader())
                    .setOnBannerListener {
                        //mContext.startActivity(new Intent(mContext, LookingActivity.class));
                    }.start()
            //

            this.banner.setOnBannerListener { v->
//                Toast.makeText(mContext,"日",Toast.LENGTH_SHORT).show()
                val intent = Intent()
                intent.setClass(mContext,TopicActivity::class.java)
                mContext.startActivity(intent)
             }

        }

    }

    internal inner class TopicViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val recyclerView:RecyclerView
        val imageIDs = ArrayList<TopicBean>()

        init {
            recyclerView = itemView.findViewById<RecyclerView>(R.id.recycler_view_topic)
        }

        fun setData() {

            for (i in 1..100){
                imageIDs.add(TopicBean(R.mipmap.default_image))
            }

            recyclerView.adapter = TopicAdapter(data = imageIDs)
            recyclerView.layoutManager = LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false)

        }
    }

    internal inner class MoreViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        val homeMoreList = ArrayList<HomeMoreBean>()
        val ivHomeMore:ImageView
        val tvTitle:TextView
        val tvComment:TextView
        val ivComment:ImageView
        val ivCollection:ImageView
        val ivShare:ImageView


        init {
            ivHomeMore =  itemView.findViewById<ImageView>(R.id.iv_home_more)
            tvTitle =  itemView.findViewById<TextView>(R.id.tv_title)
            tvComment =  itemView.findViewById<TextView>(R.id.tv_comment)
            ivComment =  itemView.findViewById<ImageView>(R.id.iv_comment)
            ivCollection =  itemView.findViewById<ImageView>(R.id.iv_collection1)
            ivShare =  itemView.findViewById<ImageView>(R.id.iv_share)
        }

        fun setData() {
            for (i in 1..100){
                homeMoreList.add(HomeMoreBean(R.mipmap.default_image))
            }

            this.itemView.setOnClickListener { view ->
                Toast.makeText(mContext,"jfdsfa",Toast.LENGTH_SHORT).show()
            }

        }


    }

    companion object {


        /**
         * 六种类型
         */
        /**
         * 横幅广告
         */
        val BANNER = 0
        /**
         * 话题
         */
        val TOPIC = 1

        /**
         * 更多
         */
        val MORE = 2
    }


}






