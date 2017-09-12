package cn.shuyuyin.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.ShareUtils
import cn.shuyuyin.ui.view.dialog.niftymodaldialogeffects.lib.NiftyDialogBuilder

/**
 * Created by wz on 17-7-9.
 * 商城 adapter
 */

class BecomeAuthorInAuditAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val dialogBuilder: NiftyDialogBuilder = NiftyDialogBuilder.getInstance(mContext)

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
            return VideoViewHolder(mContext, inflater.inflate(R.layout.item_personal_topic_video, parent,false))
        } else if (viewType == IMAGE) {
            return ImageViewHolder(mContext, inflater.inflate(R.layout.item_personal_topic_image, parent,false))
        } else if (viewType == TEXT) {
            return TextViewHolder(mContext, inflater.inflate(R.layout.item_personal_topic_text, parent,false))
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

        val ivShare: ImageView

        init {
            ivShare = itemView.findViewById(R.id.iv_share)
        }

        fun setData() {

            ivShare.setOnClickListener{

                ShareUtils.showShare(mContext)

            }

        }

    }

    internal inner class ImageViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {


        val ivShare: ImageView

        init {
            ivShare = itemView.findViewById(R.id.iv_share)
        }


        fun setData() {

            ivShare.setOnClickListener{
                ShareUtils.showShare(mContext)
            }




            itemView.setOnLongClickListener {
                dialogBuilder.withTitle(null)
                        .withDividerColor("#000000")
                        .withMessage("编辑此条内容")
                        .withMessageColor("#000000")                              //def  | withMessageColor(int resid)
                        .withDialogColor("#ffffff")                       //def  | withDialogColor(int resid)                               //def
                        .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
                        .withDuration(300)                                          //def
                                                              //def Effectstype.Slidetop
                        .withButton1Text("重发")//def gone
                        //def gone
                        .setButton1Click { dialogBuilder.dismiss() }
                        .withButton2Text("删除")                                      //def gone
                        //def gone
                        .setButton2Click { dialogBuilder.dismiss() }

                        .show()

                true
            }


        }
    }

    internal inner class TextViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {


        val ivShare: ImageView

        init {
            ivShare = itemView.findViewById(R.id.iv_share)
        }


        fun setData() {

            ivShare.setOnClickListener{

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