package com.scene.myapplication.model;

import com.scene.myapplication.bean.RecyclerViewInfo;

import java.util.List;

/**
 * Created by MVPHelper on 2016/10/21
 */

public interface RecyclerViewModel {
    interface OnLoadListener {
        void onLoadSuccess(int currentPage,List<RecyclerViewInfo> list);

        void onLoadFail();
    }


    void loadFirstPage(OnLoadListener listener);

    void loadNextPage(int currentPage, OnLoadListener listener);

}