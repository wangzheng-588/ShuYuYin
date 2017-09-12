package cn.shuyuyin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.shuyuyin.R
import cn.shuyuyin.ui.adapter.BecomeAuthorInAuditAdapter
import cn.shuyuyin.ui.base.BaseFragment
import cn.shuyuyin.ui.view.dialog.niftymodaldialogeffects.lib.Effectstype
import cn.shuyuyin.ui.view.dialog.niftymodaldialogeffects.lib.NiftyDialogBuilder
import kotlinx.android.synthetic.main.fragment_become_author_in_audit.*

/**
 * Created by wz on 17-9-12.
 * 审核中
 */
class BecomeAuthorInAuditFragment : BaseFragment() {


    var dialogBuilder: NiftyDialogBuilder? = null



    override fun setLayoutResID(): Int {
        return R.layout.fragment_become_author_in_audit
    }

    override fun init() {
        super.init()

        dialogBuilder = NiftyDialogBuilder(mContext)
    }

    override fun initData() {

        val adapter = BecomeAuthorInAuditAdapter(mContext)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)



    }


    /**
     * 警告对话框
     * @param effect
     * @param title
     * @param content
     */
    private fun showWarnDialog(effect: Effectstype, title: String, content: String) {

        dialogBuilder!!
                .withTitle(title)                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage(content)                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)                               //def
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                .withDuration(500)                                          //def
                .withEffect(effect)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")                                      //def gone
                //def gone
                .setButton1Click(object: View.OnClickListener {
                    override fun onClick(p0: View?) {
                        dialogBuilder!!.dismiss()
                    }
                })

                .show()

    }


}