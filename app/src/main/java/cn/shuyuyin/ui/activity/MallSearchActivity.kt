package cn.shuyuyin.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import cn.shuyuyin.R
import cn.shuyuyin.common.utils.DrawUtils
import cn.shuyuyin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_mall_search.*
import java.util.*


/**
 * Created by wz on 17-9-15.
 * 商城搜索
 */
class MallSearchActivity:BaseActivity() {


    private val datas = arrayOf("新手计划", "乐享活系列90天计划", "钱包", "30天理财计划(加息2%)", "林业局投资商业经营与大捞一笔", "中学老师购买车辆", "屌丝下海经商计划", "新西游影视拍", "Java培训老师自己周转", "HelloWorld", "C++-C-ObjectC-java", "Android vs ios", "算法与数据结构", "JNI与NDK", "team working")
    //初始化随机
    private var random: Random? = null


    override fun setLayoutView(): Int {
        return R.layout.activity_mall_search
    }



    override fun init() {

        random = Random()
        for (i in 0 until datas.size) {
            val textView = TextView(this)
            textView.text = datas[i]
            //提供边距的对象，并设置到textView中
            val mp = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            mp.leftMargin = 8
            mp.rightMargin = 8
            mp.topMargin = 8
            mp.bottomMargin = 8
            textView.layoutParams = mp

            //设置背景
            //设置textView的背景
            val red = random!!.nextInt(211)
            val green = random!!.nextInt(211)
            val blue = random!!.nextInt(211)
            //方式一：
            //            textView.setBackground(DrawUtils.getDrawable(Color.rgb(red, green, blue),UIUtils.dp2px(5)));

            //方式二：
            //保存按下能显示selector的效果，需要设置一个如下的属性
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                textView.background = DrawUtils.getSelector(DrawUtils.getDrawable(Color.rgb(red, green, blue),5f), DrawUtils.getDrawable(Color.WHITE, 5f))
            }
            //方式一：
            //            textView.setClickable(true);

            //添加点击事件，也是实现显示selector的效果的一种方式
            textView.setOnClickListener {
                Toast.makeText(this, textView.text, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,GoodsSearchResultActivity::class.java))
            }

            //设置边距
            //设置内边距
            val padding = 10
            textView.setPadding(padding, padding, padding, padding)


            // 2.添加到FlowLayout布局中

            flow_layout.addView(textView)
        }

    }


}