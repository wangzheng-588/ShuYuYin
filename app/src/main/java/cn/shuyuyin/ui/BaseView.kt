package cn.shuyuyin.ui

/**
 * Created by wz on 17-9-16.
 */

interface BaseView {

    fun showLoading()
    fun showError(msg: String)
    fun dismissLoading()

}
