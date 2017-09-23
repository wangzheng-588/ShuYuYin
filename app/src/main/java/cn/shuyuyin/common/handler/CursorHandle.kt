package cn.shuyuyin.common.handler

import android.content.Context
import android.provider.MediaStore
import cn.shuyuyin.bean.MusicInfoBean
import java.util.*

object CursorHandle {

    /**
     * 用于从数据库中查询歌曲的信息，保存在List集合当中
     *
     * @return
     */
     fun getMusicInfos(context: Context): List<MusicInfoBean> {
        val cursor = context.contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER)

        val musicInfos = ArrayList<MusicInfoBean>()
        for (i in 0 until cursor!!.count) {
            cursor.moveToNext()

            val id = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media._ID))    //音乐id
            val title = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.TITLE)) // 音乐标题
            val artist = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.ARTIST)) // 艺术家
            val album = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.ALBUM))    //专辑
            val displayName = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
            val albumId = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)).toLong()
            val duration = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DURATION)) // 时长
            val size = cursor.getLong(cursor
                    .getColumnIndex(MediaStore.Audio.Media.SIZE)) // 文件大小
            val url = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Audio.Media.DATA)) // 文件路径
            val isMusic = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)) // 是否为音乐

            if (isMusic != 0) { // 只把音乐添加到集合当中
                musicInfos.add(MusicInfoBean(id,title,album,albumId,displayName,artist,duration,size,url,"",""))

            }
        }
        cursor.close()
        return musicInfos
    }


    /**
     * 格式化时间，将毫秒转换为分:秒格式
     *
     */
    fun formatTime(time: Long): String {
        var min = (time / (1000 * 60)).toString() + ""
        var sec = (time % (1000 * 60)).toString() + ""
        if (min.length < 2) {
            min = "0" + time / (1000 * 60) + ""
        } else {
            min = (time / (1000 * 60)).toString() + ""
        }
        if (sec.length == 4) {
            sec = "0" + time % (1000 * 60) + ""
        } else if (sec.length == 3) {
            sec = "00" + time % (1000 * 60) + ""
        } else if (sec.length == 2) {
            sec = "000" + time % (1000 * 60) + ""
        } else if (sec.length == 1) {
            sec = "0000" + time % (1000 * 60) + ""
        }
        return min + ":" + sec.trim { it <= ' ' }.substring(0, 2)
    }
}
	
	
	
