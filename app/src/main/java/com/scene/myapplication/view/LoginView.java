package com.scene.myapplication.view;

/**
 * Created by MVPHelper on 2016/10/21
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void clearText();

    void toNextPage();

    void showErrorInfo();
}