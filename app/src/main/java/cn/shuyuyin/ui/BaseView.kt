package cn.shuyuyin.ui

/**
 * Created by wz on 17-9-16.
 */

interface BaseView {

    fun success(result: String)
    fun fail(errorMessage: String)
}
