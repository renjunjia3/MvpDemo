package com.scene.myapplication.model;

/**
 * Created by MVPHelper on 2016/10/21
 */

public interface LoginModel {

    interface LoginListener {
        void onLoginSuccess();

        void onLoginFail();
    }

    void login(String username, String password, LoginListener loginListener);

}