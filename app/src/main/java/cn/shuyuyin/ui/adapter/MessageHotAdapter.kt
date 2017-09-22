package cn.shuyuyin.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import cn.shuyuyin.R
import cn.shuyuyin.common.utils.ShareUtils
import cn.shuyuyin.ui.activity.CommentActivity
import cn.shuyuyin.ui.activity.MessageHotDetailActivity


/**
 * Created by wz on 17-7-9.
 * 商城 adapter
 */

class MessageHotAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /**
     * 当前类型
     */
    var currentType = VIDEO


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


        when (position){
            VIDEO ->{
                currentType = VIDEO
            }
            IMAGE->{
                currentType = IMAGE
            }
            TEXT->{
                currentType = TEXT
            }
        }

        return currentType

    }


    override fun getItemCount(): Int {
        return 3
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        if (viewType == VIDEO) {
            return VideoViewHolder(mContext, inflater.inflate(R.layout.item_message_hot_video, parent,false))
        } else if (viewType == IMAGE) {
            return ImageViewHolder(mContext, inflater.inflate(R.layout.item_message_hot_image, parent,false))
        } else if (viewType == TEXT) {
            return TextViewHolder(mContext, inflater.inflate(R.layout.item_message_hot_text, parent,false))
        }

        return null
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when {
            getItemViewType(position) == VIDEO -> {
                val videoViewHolder = holder as VideoViewHolder
                //设置数据Banner的数据
                videoViewHolder.setData()
            }
            getItemViewType(position) == IMAGE -> {

                val imageViewHolder = holder as ImageViewHolder
                imageViewHolder.setData()

            }
            getItemViewType(position) == TEXT -> {
                val textViewHolder = holder as TextViewHolder
                textViewHolder.setData()
            }
        }

    }


    inner class VideoViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val iv_comment = itemView.findViewById<ImageView>(R.id.iv_comment)
        private val  iv_share = itemView.findViewById<ImageView>(R.id.iv_share)



        fun setData() {


            itemView.setOnClickListener {

                val intent = Intent()
                intent.setClass(mContext, MessageHotDetailActivity::class.java)
                mContext.startActivity(intent)
            }


            iv_comment.setOnClickListener {
                mContext.startActivity(Intent(mContext,CommentActivity::class.java))
            }

            iv_share.setOnClickListener {
                ShareUtils.showShare(mContext)
            }


        }




    }

    internal inner class ImageViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val iv_comment = itemView.findViewById<ImageView>(R.id.iv_comment)
        private val  iv_share = itemView.findViewById<ImageView>(R.id.iv_share)

        fun setData() {

            itemView.setOnClickListener {

                val intent = Intent()
                intent.setClass(mContext, MessageHotDetailActivity::class.java)
                mContext.startActivity(intent)
            }


            iv_comment.setOnClickListener {
                mContext.startActivity(Intent(mContext,CommentActivity::class.java))
            }

            iv_share.setOnClickListener {
                ShareUtils.showShare(mContext)
            }
        }
    }

    internal inner class TextViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iv_comment = itemView.findViewById<ImageView>(R.id.iv_comment)
        private val  iv_share = itemView.findViewById<ImageView>(R.id.iv_share)


        fun setData() {

            itemView.setOnClickListener {

                val intent = Intent()
                intent.setClass(mContext, MessageHotDetailActivity::class.java)
                mContext.startActivity(intent)
            }


            iv_comment.setOnClickListener {
                mContext.startActivity(Intent(mContext,CommentActivity::class.java))
            }

            iv_share.setOnClickListener {
                ShareUtils.showShare(mContext)
            }

        }


    }

    companion object {


        /**
         * 三种类型
         */
        /**
         * 视频
         */
        val VIDEO = 0
        /**
         * 图片
         */
        val IMAGE = 1

        /**
         * 文本
         */
        val TEXT = 2
    }


}






