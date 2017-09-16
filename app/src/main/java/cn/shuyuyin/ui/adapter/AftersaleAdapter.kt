package cn.shuyuyin.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import cn.shuyuyin.R



/**
 * Created by wz on 17-9-15.
 */
class AftersaleAdapter(val context: Context,val strings: ArrayList<String>):BaseAdapter() {



    override fun getCount(): Int {
        return strings.size
    }

    override fun getItem(i: Int): String {
        return strings.get(i)
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {
       var view = convertView
        val viewHolder: ViewHolder
        if (view == null) {
            view = View.inflate(context, R.layout.item_return_reason, null)

            viewHolder = ViewHolder(view)
            view!!.tag = viewHolder
        } else {
            viewHolder = view.getTag() as ViewHolder
        }

        viewHolder.mTvShopName!!.text = getItem(i)
        return view
    }

    internal class ViewHolder(view: View) {
        var mTvShopName: TextView? = view.findViewById(R.id.tv_desc)

    }

}