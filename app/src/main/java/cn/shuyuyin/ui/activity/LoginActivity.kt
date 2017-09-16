package cn.shuyuyin.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.widget.Toast
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.PlatformActionListener
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.sina.weibo.SinaWeibo
import cn.sharesdk.tencent.qq.QQ
import cn.sharesdk.wechat.friends.Wechat
import cn.shuyuyin.R
import cn.shuyuyin.common.AppManager
import cn.shuyuyin.ui.base.BaseActivity
import com.mob.MobSDK
import com.mob.tools.utils.UIHandler
import kotlinx.android.synthetic.main.activity_login.*


/**
 * Created by wz on 17-9-11.
 * 登录
 */
class LoginActivity : BaseActivity(), Handler.Callback, PlatformActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobSDK.init(this)
    }

    override fun setLayoutView(): Int {
        return R.layout.activity_login
    }


    override fun initListener() {
        super.initListener()


        iv_close.setOnClickListener { finish() }


        btn_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        tv_forget_password.setOnClickListener {
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
            AppManager.appManager.addActivity(this)
        }

        tv_reg.setOnClickListener {
            startActivity(Intent(this, RegActivity::class.java))
            AppManager.appManager.addActivity(this)
        }

        iv_login_qq.setOnClickListener {

            qqLogin()

        }

        iv_login_weixin.setOnClickListener {
            weixinLogin()
        }

        iv_login_sina.setOnClickListener {

            sinaLogin()
        }
    }

    private fun sinaLogin() {

        val weibo = ShareSDK.getPlatform(SinaWeibo.NAME)
        //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
        weibo.platformActionListener = object : PlatformActionListener {

            override fun onError(arg0: Platform, arg1: Int, arg2: Throwable) {
                arg2.printStackTrace()
            }

            override fun onComplete(arg0: Platform, arg1: Int, arg2: HashMap<String, Any>) {

                //输出所有授权信息
                arg0.db.exportData()
            }

            override fun onCancel(arg0: Platform, arg1: Int) {


            }
        }
        //authorize与showUser单独调用一个即可
        weibo.authorize()//单独授权,OnComplete返回的hashmap是空的
        weibo.showUser(null)//授权并获取用户信息
        //移除授权
        //weibo.removeAccount(true);

    }

    private fun weixinLogin() {

        authorize(Wechat(), false)

    }


    // 授权登录
    private fun authorize(plat: Platform, isSSO: Boolean?) {
        // 判断指定平台是否已经完成授权
        if (plat.isAuthValid) {
            // 已经完成授权，直接读取本地授权信息，执行相关逻辑操作（如登录操作）
            val userId = plat.db.userId
            if (!TextUtils.isEmpty(userId)) {
                UIHandler.sendEmptyMessage(MSG_USERID_FOUND, this@LoginActivity)
                login(plat.name, userId, null)
                return
            }
        }
        plat.platformActionListener = this@LoginActivity
        // 是否使用SSO授权：true不使用，false使用
        plat.SSOSetting(isSSO!!)
        // 获取用户资料
        plat.showUser(null)
    }


    // 取消授权
    private fun cancleAuth() {
        val wxPlatform = ShareSDK.getPlatform(Wechat.NAME)
        wxPlatform.removeAccount(true)
        Toast.makeText(this, "取消授权成功!", Toast.LENGTH_SHORT).show()
    }

    // 回调：授权成功
    override fun onComplete(platform: Platform, action: Int, res: java.util.HashMap<String, Any>) {
        if (action == Platform.ACTION_USER_INFOR) {
            UIHandler.sendEmptyMessage(MSG_AUTH_COMPLETE, this)
            // 业务逻辑处理：比如登录操作
            val userName = platform.db.userName // 用户昵称
            val userId = platform.db.userId      // 用户Id
            val platName = platform.name              // 平台名称

            login(platName, userName, res)
        }
    }

    // 回调：授权失败
    override fun onError(platform: Platform, action: Int, t: Throwable) {
        if (action == Platform.ACTION_USER_INFOR) {
            UIHandler.sendEmptyMessage(MSG_AUTH_ERROR, this)
        }
        t.printStackTrace()
    }

    // 回调：授权取消
    override fun onCancel(platform: Platform, action: Int) {
        if (action == Platform.ACTION_USER_INFOR) {
            UIHandler.sendEmptyMessage(MSG_AUTH_CANCEL, this)
        }
    }

    // 业务逻辑：登录处理
    private fun login(plat: String, userId: String, userInfo: java.util.HashMap<String, Any>?) {
        Toast.makeText(this, "用户ID:" + userId, Toast.LENGTH_SHORT).show()
        val msg = Message()
        msg.what = MSG_LOGIN
        msg.obj = plat
        UIHandler.sendMessage(msg, this)
    }

    // 统一消息处理
    private val MSG_USERID_FOUND = 1 // 用户信息已存在
    private val MSG_LOGIN = 2 // 登录操作
    private val MSG_AUTH_CANCEL = 3 // 授权取消
    private val MSG_AUTH_ERROR = 4 // 授权错误
    private val MSG_AUTH_COMPLETE = 5 // 授权完成

    override fun handleMessage(msg: Message): Boolean {
        when (msg.what) {

            MSG_USERID_FOUND -> Toast.makeText(this, "用户信息已存在，正在跳转登录操作......", Toast.LENGTH_SHORT).show()
            MSG_LOGIN -> Toast.makeText(this, "使用微信帐号登录中...", Toast.LENGTH_SHORT).show()
            MSG_AUTH_CANCEL -> Toast.makeText(this, "授权操作已取消", Toast.LENGTH_SHORT).show()
            MSG_AUTH_ERROR -> Toast.makeText(this, "授权操作遇到错误，请阅读Logcat输出", Toast.LENGTH_SHORT).show()
            MSG_AUTH_COMPLETE -> {
                Toast.makeText(this, "授权成功，正在跳转登录操作…", Toast.LENGTH_SHORT).show()
                // 执行相关业务逻辑操作，比如登录操作
                Wechat().db.userName
                val userId = Wechat().db.userId   // 用户Id
                val platName = Wechat().name               // 平台名称

                login(platName, userId, null)
            }
        }
        return false
    }










    private fun qqLogin() {

        val weibo = ShareSDK.getPlatform(QQ.NAME)
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
        weibo.platformActionListener = object : PlatformActionListener {

            override fun onError(arg0: Platform, arg1: Int, arg2: Throwable) {
                // TODO Auto-generated method stub
                arg2.printStackTrace()
            }

            override fun onComplete(arg0: Platform, arg1: Int, arg2: HashMap<String, Any>) {
                // TODO Auto-generated method stub
                //输出所有授权信息
                arg0.db.exportData()
            }

            override fun onCancel(arg0: Platform, arg1: Int) {
                // TODO Auto-generated method stub

            }
        }
//authorize与showUser单独调用一个即可
        weibo.authorize()//单独授权,OnComplete返回的hashmap是空的
        weibo.showUser(null)//授权并获取用户信息
//移除授权
//weibo.removeAccount(true);


    }


    override fun init() {

    }
}