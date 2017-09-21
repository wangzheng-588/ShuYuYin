package cn.shuyuyin.common.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle

import cn.shuyuyin.R
import cn.shuyuyin.common.DoubleClickUtil


object ActivityUtil {

    fun startActivityNotInActivity(context: Context, targetActivity: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(context, targetActivity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
        (context as Activity).overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivity(activity: Activity, targetActivity: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(activity, targetActivity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivityWithFinish(activity: Activity, targetActivity: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(activity, targetActivity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivity(activity: Activity, targetActivity: Class<*>, map: Map<String, String>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(activity, targetActivity)
        for ((key, value) in map) {
            intent.putExtra(key, value)
        }
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivity(activity: Activity, uri: Uri, bundle: Bundle?) {
        if (!DoubleClickUtil.isFastDoubleClick)
            return
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivity(activity: Activity, action: String, bundle: Bundle?) {
        if (!DoubleClickUtil.isFastDoubleClick)
            return
        val intent = Intent()
        intent.action = action
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivityForResult(activity: Activity, action: String, bundle: Bundle?, result: Int) {
        if (!DoubleClickUtil.isFastDoubleClick)
            return
        val intent = Intent()
        intent.action = action
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivityForResult(intent, result)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    @JvmOverloads fun startActivityForResult(activity: Activity, action: String, uri: Uri, result: Int, bundle: Bundle? = null) {
        if (!!DoubleClickUtil.isFastDoubleClick)
            return
        val intent = Intent(action, uri)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivityForResult(intent, result)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    @JvmOverloads fun startActivityForResult(activity: Activity, targetActivity: Class<*>, result: Int, bundle: Bundle? = null) {
        if (!!DoubleClickUtil.isFastDoubleClick)
            return
        val intent = Intent()
        intent.setClass(activity, targetActivity)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivityForResult(intent, result)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }

    fun startActivityForResult(activity: Activity, intent: Intent?, result: Int, bundle: Bundle?) {
        if (intent == null || !!DoubleClickUtil.isFastDoubleClick)
            return
        if (bundle != null)
            intent.putExtras(bundle)
        activity.startActivityForResult(intent, result)
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back)
    }
}
