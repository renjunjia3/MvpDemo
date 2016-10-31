package com.scene.myapplication.model;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by MVPHelper on 2016/10/31
 */

public class SaveImageModelImpl implements SaveImageModel {

    @Override
    public void saveImage(final ImageView imageView, final OnSaveImageListener onSaveImageListener) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    if (bitmap != null) {
                        onSaveImageListener.onSaveSuccess();
                        Log.e("saveImage","图片宽："+bitmap.getWidth());
                        Log.e("saveImage","图片高："+bitmap.getHeight());
                    } else {
                        onSaveImageListener.onSaveFail("Fail");
                    }
                } catch (Exception e) {
                    onSaveImageListener.onSaveFail(e.getMessage());
                }
            }
        });
    }


}