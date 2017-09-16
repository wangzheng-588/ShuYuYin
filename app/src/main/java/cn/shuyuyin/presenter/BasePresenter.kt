package cn.shuyuyin.presenter

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import cn.shuyuyin.ui.BaseView


/**
 * Created by Ivan on 2017/1/3.
 */

open class BasePresenter< out M,  out V : BaseView>(val mModel: M, val mView: V) {


    lateinit var mContext: Context


    init {

        initContext()

    }


    private fun initContext() {


        mContext = if (mView is Fragment) {
            (mView as Fragment).activity
        } else {
            mView as Activity
        }
    }


}
