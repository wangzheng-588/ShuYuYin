package cn.shuyuyin.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import cn.shuyuyin.R
import cn.shuyuyin.presenter.BasePresenter
import cn.shuyuyin.ui.BaseView
import com.github.ybq.android.spinkit.style.Circle
import com.github.ybq.android.spinkit.style.DoubleBounce
import kotlinx.android.synthetic.main.fragment_progress.*


abstract class ProgressFragment<T:BasePresenter<*,*>> : Fragment(), BaseView {

     var mPresenter: T? = null

    private var mRootView: FrameLayout? = null

    protected lateinit var mContext:Context

    private var mViewProgress: View? = null
    private var mViewContent: FrameLayout? = null
    private var mViewEmpty: View? = null
    private var mTextError: TextView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mContext = activity

        mRootView = inflater!!.inflate(R.layout.fragment_progress, container, false) as FrameLayout
        mViewProgress = mRootView!!.findViewById(R.id.view_progress)
        mViewContent = mRootView!!.findViewById(R.id.view_content)
        mViewEmpty = mRootView!!.findViewById(R.id.view_empty)
      //  mProgress = mRootView!!.findViewById(R.id.progress)

        mTextError = mRootView!!.findViewById(R.id.text_tip)

        mViewEmpty!!.setOnClickListener { onEmptyViewClick() }


        return mRootView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRealContentView()

        initListener()
        init()
        initData()
    }

    open fun initListener() {

    }

    open fun initData() {

    }

    fun onEmptyViewClick() {



    }

    private fun setRealContentView() {

        val realContentView = LayoutInflater.from(activity).inflate(setLayout(), mViewContent, true)

        initRealContentView(realContentView)
    }


    private fun showProgressView() {
        showView(R.id.view_progress)

      //  mProgress!!.startAnim()
        val doubleBounce = DoubleBounce()
        val circle = Circle()
        spin_kit.setIndeterminateDrawable(circle)

    }

    private fun showContentView() {

        showView(R.id.view_content)
    }

    private fun showEmptyView() {

        showView(R.id.view_empty)
    }


    fun showEmptyView(resId: Int) {


        showEmptyView()
        mTextError!!.setText(resId)
    }

    private fun showEmptyView(msg: String) {


        showEmptyView()
        mTextError!!.text = msg
    }


    private fun showView(viewId: Int) {

        for (i in 0 until mRootView!!.childCount) {

            if (mRootView!!.getChildAt(i).id == viewId) {

                mRootView!!.getChildAt(i).visibility = View.VISIBLE
            } else {
                mRootView!!.getChildAt(i).visibility = View.GONE
            }

        }


    }


    override fun showLoading() {
        showProgressView()
    }

    override fun showError(msg: String) {

        showEmptyView(msg)
       // mProgress!!.stopAnim()
    }

    override fun dismissLoading() {
        showContentView()
      //  mProgress!!.stopAnim()
    }

    abstract fun setLayout(): Int

    abstract fun init()


    protected abstract fun initRealContentView(realContentView: View)



}
