package cn.shuyuyin.common.task;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.io.File;

import cn.shuyuyin.common.download.DownloadProgressListener;
import cn.shuyuyin.common.download.FileDownloader;

/**
 * Created by wz on 17-9-22.
 */

public class DownloadTask  implements Runnable {

    private static final int PROCESSING = 1;
    private static final int FAILURE = -1;
    private final Handler handler;
    private final Context context;

    private String path;
    private File saveDir;
    private FileDownloader loader;

    public DownloadTask(Context context,Handler handler, String path, File saveDir) {
        this.path = path;
        this.saveDir = saveDir;
        this.handler = handler;
        this.context =context;
    }

    /**
     * 退出下载
     */
    public void exit() {
        if (loader != null)
            loader.exit();
    }

    DownloadProgressListener downloadProgressListener = new DownloadProgressListener() {
        @Override
        public void onDownloadSize(int size) {
            Message msg = new Message();
            msg.what = PROCESSING;
            msg.getData().putInt("size", size);
            handler.sendMessage(msg);
        }
    };

    public void run() {
        try {
            // 实例化一个文件下载器
            loader = new FileDownloader(context, path,
                    saveDir, 3);
            // 设置进度条最大值
           // progressBar.setMax(loader.getFileSize());
            loader.download(downloadProgressListener);
        } catch (Exception e) {
            e.printStackTrace();
            handler.sendMessage(handler.obtainMessage(FAILURE)); // 发送一条空消息对象
        }
    }
}
