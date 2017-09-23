package cn.shuyuyin.common.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.shuyuyin.ui.activity.LockScreenActivity;

/**
 * Created by wz on 17-9-23.
 */

public class ScreenBroadcastReceiver extends BroadcastReceiver {

    private String action;
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        action = intent.getAction();
        if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏
            Intent lockscreen = new Intent(context, LockScreenActivity.class);
            lockscreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(lockscreen);
        } else if (Intent.ACTION_USER_PRESENT.equals(action)) { // 解锁

        }
    }
}
