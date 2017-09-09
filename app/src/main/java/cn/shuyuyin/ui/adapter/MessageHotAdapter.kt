package cn.shuyuyin.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.shuyuyin.R
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

        if (getItemViewType(position) == VIDEO) {
            val videoViewHolder = holder as VideoViewHolder
            //设置数据Banner的数据
            videoViewHolder.setData()
        } else if (getItemViewType(position) == IMAGE) {

            val imageViewHolder = holder as ImageViewHolder
            imageViewHolder.setData()

        } else if (getItemViewType(position) == TEXT) {
            val textViewHolder = holder as TextViewHolder
            textViewHolder.setData()
        }

    }


    inner class VideoViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {




        fun setData() {


            itemView.setOnClickListener { v->

                val intent = Intent()
                intent.setClass(mContext, MessageHotDetailActivity::class.java)
                mContext.startActivity(intent)

            }

        }




    }

    internal inner class ImageViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun setData() {

        }
    }

    internal inner class TextViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {




        fun setData() {


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






