package cn.shuyuyin.ui.view.crop.dialog;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import cn.shuyuyin.R;
import cn.shuyuyin.ui.view.crop.UCrop;
import cn.shuyuyin.ui.view.crop.activity.UCropActivity;

import static cn.shuyuyin.common.utils.BitmapCompressor.getBitmapFormUri;


/**
 * Created by ywl on 2016/6/14.
 */
public class PickPhotoDialog extends BaseDialog {


    private final Context mContext;
    private OnPhotoResultListener onPhotoResultListener;
    private static final int REQUEST_CAMERA_CODE = 0x0002;
    private static final int REQUEST_EXTERNAL_STORAGE_CODE = 0x0003;
    private static final int REQUEST_CAMERA_RESULT_CODE = 0x0004;
    private static final int REQUEST_CLICK_PHOTO_CODE = 0x0005;

    private Activity activity;
    private File file;
    private Uri imageUri;
    private String imgname = "";

    private boolean isCutImg = true;
    private int maxcount = 1;
    private Uri mDestinationUri;

    private Button btnCamera;
    private Button btnPhoto;
    private static final int REQUEST_SELECT_PICTURE = 0x01;
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage.jpeg";
    private Button btnCancel;

    public PickPhotoDialog(Context context, Activity activity) {
        super(context);
        this.mContext = context;
        this.activity = activity;
        mDestinationUri = Uri.fromFile(new File(context.getCacheDir(), SAMPLE_CROPPED_IMAGE_NAME));
    }

    public void setCutImg(boolean cutImg) {
        isCutImg = cutImg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_choice_photo_layout);
        btnCamera = findViewById(R.id.btn_takephoto);
        btnPhoto =  findViewById(R.id.btn_photo);
        btnCancel = findViewById(R.id.btn_cancel);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(context, "当前存储卡不可用", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED//相机权限
                        || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED//读取存储卡权限
                        || ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA_CODE);
                } else {
                    file = new File(getImgPath());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    imgname = getHeadImgName();
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    imageUri = Uri.fromFile(new File(file, imgname));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    activity.startActivityForResult(intent, REQUEST_CAMERA_RESULT_CODE);
                }
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(context, "当前存储卡不可用", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE_CODE);
                } else {
                    pickFromGallery();
                }


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickPhotoDialog.this.dismiss();
            }
        });
    }


    private void pickFromGallery() {


        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(Intent.createChooser(intent, "label_select_picture"), REQUEST_SELECT_PICTURE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != activity.RESULT_OK) {
            return;
        }


        if (requestCode == REQUEST_CAMERA_RESULT_CODE) {
            try {
                MediaStore.Images.Media.insertImage(context.getContentResolver(),
                        imageUri.getPath(), imgname, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // 最后通知图库更新
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));



            if (isCutImg) {
                startCropActivity(imageUri);
                dismiss();
            } else {
                if (onPhotoResultListener!=null){
                    try {
                        Bitmap bitmap = getBitmapFormUri(activity, imageUri);
                        onPhotoResultListener.onPhotoResult(imageUri);
                        onPhotoResultListener.onCutPhotoResult(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } else if (requestCode == REQUEST_SELECT_PICTURE) {



            final Uri selectedUri = data.getData();

            if (isCutImg){
                if (selectedUri != null) {
                    startCropActivity(data.getData());
                } else {
                    //ToastUtil.show("无法检索图片");
                    // Toast.makeText(RegBaseDataActivity.this, R, Toast.LENGTH_SHORT).show();
                }
            } else {
                if (selectedUri!=null){
                    if (onPhotoResultListener!=null){
                        try {
                            Bitmap bitmap = getBitmapFormUri(activity, selectedUri);
                            onPhotoResultListener.onPhotoResult(selectedUri);
                            onPhotoResultListener.onCutPhotoResult(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }

        }


        if (resultCode == UCrop.RESULT_ERROR) {
            handleCropError(data);
        }

        if (requestCode == UCrop.REQUEST_CROP) {
            handleCropResult(data);

        }
        dismiss();


    }


    private void handleCropError(@NonNull Intent result) {
        final Throwable cropError = UCrop.getError(result);
        if (cropError != null) {
            //  Log.e(TAG, "handleCropError: ", cropError);
//            ToastUtil.show(cropError.getMessage());
            Toast.makeText(mContext,cropError.getMessage(),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext,"意外错误",Toast.LENGTH_SHORT).show();
        }
    }


    private void handleCropResult(@NonNull Intent result) {
        final Uri resultUri = UCrop.getOutput(result);
        if (resultUri != null) {
            try {
                Bitmap bitmap = getBitmapFormUri(activity, resultUri);

                if (onPhotoResultListener != null) {
                    onPhotoResultListener.onPhotoResult(resultUri);
                }

                if (bitmap != null) {
                    if (onPhotoResultListener != null) {
                        onPhotoResultListener.onCutPhotoResult(bitmap);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {
//            ToastUtil.show("不能找到裁剪图片");
            Toast.makeText(mContext,"不能找到裁剪图片",Toast.LENGTH_SHORT).show();
        }
        dismiss();
    }


    private void startCropActivity(@NonNull Uri uri) {
        UCrop uCrop = UCrop.of(uri, mDestinationUri);


        uCrop = advancedConfig(uCrop);
        uCrop.withTargetActivity(UCropActivity.class);

        uCrop.start(activity);
    }


    private UCrop advancedConfig(@NonNull UCrop uCrop) {
        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.JPEG);

        return uCrop.withOptions(options);
    }


    public void setOnPhotoResultListener(OnPhotoResultListener onPhotoResultListener) {
        this.onPhotoResultListener = onPhotoResultListener;
    }

    public interface OnPhotoResultListener {
        void onCameraResult(String path);

        void onCutPhotoResult(Bitmap bitmap);

        void onPhotoResult(Uri selectedImgs);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == REQUEST_CAMERA_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "camera--1", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "请允许打开摄像头权限", Toast.LENGTH_SHORT).show();
            }
            return;
        } else if (requestCode == REQUEST_EXTERNAL_STORAGE_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(context, "请允许读取存储卡权限", Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode != activity.RESULT_OK)
//            return;
//        if (requestCode == REQUEST_CAMERA_RESULT_CODE) {
//            try {
//                MediaStore.Images.Media.insertImage(context.getContentResolver(),
//                        imageUri.getPath(), imgname, null);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            // 最后通知图库更新
//            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));
//
//            if (!isCutImg) {
//                if (onPhotoResultListener != null) {
//                    onPhotoResultListener.onCameraResult(imageUri.getPath());
//                }
//                dismiss();
//            } else {
//                cropPhoto(imageUri);
//            }
//        } else if (requestCode == REQUEST_CLICK_PHOTO_CODE) {
//            Bitmap photo = data.getParcelableExtra("data");
//            if (photo != null) {
//                if (onPhotoResultListener != null) {
//                    onPhotoResultListener.onCutPhotoResult(photo);
//                }
//            }
//            dismiss();
//        }
//    }

    public void cropPhoto(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");// mUri是已经选择的图片Uri
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);// 裁剪框比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 320);// 输出图片大小
        intent.putExtra("outputY", 320);
        intent.putExtra("return-data", true);
        activity.startActivityForResult(intent, REQUEST_CLICK_PHOTO_CODE);
    }

    public String getImgPath() {
        return Environment.getExternalStorageDirectory().getPath() + "/bdgames/images/";
    }

    public String getHeadImgName() {
        return System.currentTimeMillis() + ".jpg";
    }
}
