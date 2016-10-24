package com.scene.myapplication.model;


import android.os.Handler;

/**
 * Created by MVPHelper on 2016/10/21
 * //具体实现调用接口等操作
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final LoginListener loginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.equals("admin") && password.equals("123456")) {
                    loginListener.onLoginSuccess();
                } else {
                    loginListener.onLoginFail();
                }
            }
        }, 2000);

    }

}