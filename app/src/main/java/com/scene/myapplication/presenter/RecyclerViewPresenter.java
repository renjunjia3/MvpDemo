package com.scene.myapplication.presenter;

/**
 * @FileName:com.scene.myapplication.presenter.RecyclerViewPresenter.java
 * @功能描述：
 * @author: scene
 * @date: 2016-10-21 16:56
 */
public interface RecyclerViewPresenter {
    void loadFirstPage(boolean isShowProgressBar);

    void loadNextPage(int currentPage);
}
