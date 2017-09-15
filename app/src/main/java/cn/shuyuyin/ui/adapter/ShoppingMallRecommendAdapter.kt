package cn.shuyuyin.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.GlideImageLoader
import cn.shuyuyin.ui.activity.RecommendDetailActivity
import cn.shuyuyin.ui.activity.TopicActivity
import com.youth.banner.Banner
import java.util.*

/**
 * Created by wz on 17-7-9.
 * 商城 推荐
 */

class ShoppingMallRecommendAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    /**
     * 将RecyclerView的网格布局中的某个item设置为独占一行、只占一列，只占两列、等等
     * @param gridLayoutManager
     */

    fun setSpanCount(gridLayoutManager: GridLayoutManager) {
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val type = getItemViewType(position)
                return if (type == CATEGORY) {
                    1//只占一行中的一列，
                } else {
                    gridLayoutManager.spanCount//独占一行
                }
            }
        }

    }


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
        } else if (position== TITLE){
           currentType = TITLE
        } else {
            currentType = CATEGORY
        }
        return currentType
    }


    override fun getItemCount(): Int {
        return 2+100
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        if (viewType == BANNER) {
            return BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null))
        }  else if (viewType == TITLE){
            return TitleViewHolder(mContext,inflater.inflate(R.layout.recommend_title, null))
        } else if (viewType == CATEGORY) {
            return CategoryViewHolder(mContext, inflater.inflate(R.layout.item_mall_category_recommend, parent, false))
        }

        return null
    }




    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == BANNER) {
            val bannerViewHolder = holder as BannerViewHolder
            //设置数据Banner的数据
            bannerViewHolder.setData()
        }else if (getItemViewType(position) == CATEGORY) {
            val moreViewHolder = holder as CategoryViewHolder
            moreViewHolder.setData(position)
        }

    }


    inner class TitleViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title:TextView

        init {
            title = itemView.findViewById(R.id.tv_title)
            title.text = "热门推荐"
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
                intent.setClass(mContext, TopicActivity::class.java)
                mContext.startActivity(intent)
             }

        }

    }



    internal inner class CategoryViewHolder(private val mContext: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var ivRecommend: ImageView
        private var tvRecommendTitle: TextView
        private var rlRecommend: RelativeLayout


        init {
            ivRecommend = itemView.findViewById(R.id.iv_recommend)
            tvRecommendTitle = itemView.findViewById(R.id.tv_recommend_name)
            rlRecommend = itemView.findViewById(R.id.rl_recommend)
        }



        fun setData(position: Int) {

            if (currentType== CATEGORY){
                val params = rlRecommend.getLayoutParams() as LinearLayout.LayoutParams
                if (position%2==0){
                    params.leftMargin = 16
                    params.rightMargin = 0
                } else{
                    params.rightMargin = 16
                    params.leftMargin = 0

                }
                rlRecommend.layoutParams = params

            }

            tvRecommendTitle.text = "呆呆鸟"


            this.itemView.setOnClickListener {
                val intent = Intent(mContext, RecommendDetailActivity::class.java)
                intent.putExtra("type",0)
                mContext.startActivity(intent)
            }

        }


    }

    companion object {


        /**
         * 二种类型
         */
        /**
         * 横幅广告
         */
        val BANNER = 0

        /**
         * 分类
         */
        val CATEGORY = 2

        /**
         * 标题
         */
        val TITLE = 1
    }




}