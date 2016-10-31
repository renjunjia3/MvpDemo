package com.scene.myapplication.model;

import android.widget.ImageView;

/**
 * Created by MVPHelper on 2016/10/31
 */

public interface SaveImageModel {
    public interface OnSaveImageListener {
        void onSaveSuccess();

        void onSaveFail(String str);
    }

    void saveImage(ImageView imageView,OnSaveImageListener onSaveImageListener);
}