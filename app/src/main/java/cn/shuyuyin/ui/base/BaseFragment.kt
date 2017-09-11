package cn.shuyuyin.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


/**
 * Created by wz on 17-9-7.
 */
abstract class BaseFragment: Fragment() {


    protected lateinit var mContext: Context


    private var isFragmentVisible: Boolean = false
    private var isReuseView: Boolean = false
    private var isFirstVisible: Boolean = false
    private var rootView: View? = null


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (rootView == null) {
            return
        }
        if (isFirstVisible && isVisibleToUser) {
            onFragmentFirstVisible()
            isFirstVisible = false
        }
        if (isVisibleToUser) {
            onFragmentVisibleChange(true)
            isFragmentVisible = true
            return
        }
        if (isFragmentVisible) {
            isFragmentVisible = false
            onFragmentVisibleChange(false)
        }
    }

    protected fun onFragmentVisibleChange(isVisible: Boolean) {

    }

    protected fun onFragmentFirstVisible() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariable()
    }

    override fun onCreateView(inflater: LayoutInflater?,container: ViewGroup?,  savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(setLayoutResID(), null)
        mContext = activity

        initView(view)
        return view
    }

    override fun onViewCreated(view: View?,savedInstanceState: Bundle?) {

        if (rootView == null) {
            rootView = view
            if (userVisibleHint) {
                if (isFirstVisible) {
                    onFragmentFirstVisible()
                    isFirstVisible = false
                }
                onFragmentVisibleChange(true)
                isFragmentVisible = true
            }
        }
        super.onViewCreated(if (isReuseView) rootView else view, savedInstanceState)


    }



    override fun onActivityCreated( savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initListener()
        init()
        initData()
    }


    protected abstract fun setLayoutResID(): Int

    open protected fun initView(view: View) {}

    open protected fun initListener(){}

    open protected fun init() {}

    protected abstract fun initData()


    protected fun reuseView(isReuse: Boolean) {
        isReuseView = isReuse
    }

    protected fun isFragmentVisible(): Boolean {
        return isFragmentVisible
    }


    private fun initVariable() {
        isFirstVisible = true
        isFragmentVisible = false
        rootView = null
        isReuseView = true
    }


    override fun onDestroy() {


        initVariable()

        super.onDestroy()
    }


    fun setMarginTop(page: Int, view: View) {
        val layoutParam = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        layoutParam.setMargins(0, page, 0, 0)

        Log.e("TAB", "page" + page)
        view.layoutParams = layoutParam
        view.invalidate()
    }

}

