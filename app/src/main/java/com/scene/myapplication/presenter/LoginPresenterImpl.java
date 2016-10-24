package com.scene.myapplication.presenter;


import com.scene.myapplication.model.LoginModel;
import com.scene.myapplication.model.LoginModelImpl;
import com.scene.myapplication.view.LoginView;

/**
 * Created by MVPHelper on 2016/10/21
 */

public class LoginPresenterImpl implements LoginPresenter, LoginModel.LoginListener {
    private LoginView loginView;
    private LoginModelImpl loginModelImpl;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModelImpl = new LoginModelImpl();
    }

    @Override
    public void login(String username, String password) {
        if (loginView == null) {
            return;
        }
        loginView.showProgress();
        loginModelImpl.login(username, password, this);
    }

    @Override
    public void clear() {
        if (loginView != null) {
            loginView.clearText();
        }
    }

    @Override
    public void destory() {
        loginView = null;
    }

    @Override
    public void onLoginSuccess() {
        if (loginView == null) {
            return;
        }

        loginView.hideProgress();
        loginView.toNextPage();
    }

    @Override
    public void onLoginFail() {
        if (loginView == null) {
            return;
        }
        loginView.hideProgress();
        loginView.showErrorInfo();
    }
}