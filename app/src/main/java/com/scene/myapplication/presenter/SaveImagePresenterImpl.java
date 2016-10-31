package com.scene.myapplication.presenter;


import android.widget.ImageView;

import com.scene.myapplication.model.SaveImageModel;
import com.scene.myapplication.model.SaveImageModelImpl;
import com.scene.myapplication.view.SaveImageView;

/**
 * Created by MVPHelper on 2016/10/31
 */

public class SaveImagePresenterImpl implements SaveImagePresenter, SaveImageModel.OnSaveImageListener {
    private SaveImageView saveImageView;
    private SaveImageModelImpl saveImageModelImpl;

    public SaveImagePresenterImpl(SaveImageView saveImageView) {
        this.saveImageView = saveImageView;
        saveImageModelImpl = new SaveImageModelImpl();
    }

    @Override
    public void saveImage(ImageView imageView) {
        if (saveImageView != null) {
            saveImageView.showProgress();
            saveImageModelImpl.saveImage(imageView, this);
        }
    }

    @Override
    public void destory() {
        saveImageView = null;
    }

    @Override
    public void onSaveSuccess() {
        if (saveImageView != null) {
            saveImageView.hideProgress();
            saveImageView.showSuccessInfo();
        }
    }

    @Override
    public void onSaveFail(String str) {
        if (saveImageView != null) {
            saveImageView.hideProgress();
            saveImageView.showErrorInfo(str);
        }
    }
}