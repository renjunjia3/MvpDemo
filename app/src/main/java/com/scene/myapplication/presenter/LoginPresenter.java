package com.scene.myapplication.presenter;

/**
 * @FileName:com.scene.myapplication.presenter.LoginPresenter.java
 * @功能描述：
 * @author: scene
 * @date: 2016-10-21 15:41
 */
public interface LoginPresenter {
    void login(String username, String password);

    void clear();

    void destory();
}
