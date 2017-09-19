package cn.shuyuyin.presenter

import cn.shuyuyin.data.MainInfoModel
import cn.shuyuyin.presenter.contract.MainInfoContract

/**
 * Created by wz on 17-9-16.
 */
class MainInfoPresenter(model: MainInfoModel = MainInfoModel(), val view: MainInfoContract.WenziView): BasePresenter<MainInfoModel, MainInfoContract.WenziView>(model,view) {


    fun getWenziData(){


//        view.showError("加载错误")
        view.showResult()
//        view.showLoading()
    }



}