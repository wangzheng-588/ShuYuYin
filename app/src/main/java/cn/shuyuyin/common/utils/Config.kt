package cn.shuyuyin.common.utils

/**
 * Created by wz on 17-9-11.
 */

object Config {

    val INFOMATION_GENDER = "INFOMATION_GENDER"
    val INFOMATION_GENDER_REQUEST_CODE = 100


    //播放相关
    val MSG_PLAY = 1        //播放
    val MSG_PAUSE_RUSUME = 2        //暂停
    val MSG_STOP = 3        //停止
    val MSG_PRIVIOUS = 4    //上一首
    val MSG_NEXT = 5        //下一首
    val MSG_CHANGE_PROGRESS = 6//进度改变
    val MSG_PLAY_DETAIL = 7    //用于更新detail界面当前进度UI

    //音乐更新action
    val ACTION_UPDATE_INFO = "android.intent.action.ACTION_UPDATE_INFO"
    val MUSIC_SERVICE: String = "com.shuyuyin.MUSIC_SERVICE"


}
