package cn.shuyuyin.presenter.contract

import cn.shuyuyin.ui.BaseView

/**
 * Created by wz on 17-9-16.
 */
interface MainInfoContract {

    interface View:BaseView{

        fun showResult()

    }

    interface WenziView:BaseView{
        fun showResult()
    }

    interface YanchanghuiView:BaseView{
        fun showResult()
    }

    interface MessageView:BaseView{
        fun showResult()
    }

    interface MyView:BaseView{
        fun showResult()
    }
}