package com.scene.myapplication.view;

import com.scene.myapplication.bean.RecyclerViewInfo;

import java.util.List;

/**
 * Created by MVPHelper on 2016/10/21
 */

public interface RecyclerViewView {
    void loadFirstPage(boolean isShowProgressBar);

    void loadNextPage(int currentPage);

    void showProgressBar();

    void hideProgressBar();

    void showFailInfo();

    void updateRecyclerView(int currentPage,List<RecyclerViewInfo> list);
}