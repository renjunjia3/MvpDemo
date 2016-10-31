package com.scene.myapplication.view;

/**
 * Created by MVPHelper on 2016/10/31
 */

public interface SaveImageView {
    void showProgress();

    void hideProgress();

    void showErrorInfo(String str);

    void showSuccessInfo();
}