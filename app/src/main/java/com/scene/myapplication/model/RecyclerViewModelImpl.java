package com.scene.myapplication.model;


import android.os.Handler;

import com.scene.myapplication.bean.RecyclerViewInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MVPHelper on 2016/10/21
 */

public class RecyclerViewModelImpl implements RecyclerViewModel {

    @Override
    public void loadFirstPage(final OnLoadListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<RecyclerViewInfo> list = new ArrayList<RecyclerViewInfo>();
                for (int i = 0; i < 10; i++) {
                    RecyclerViewInfo info = new RecyclerViewInfo();
                    info.setTitle("这是标题：" + i);
                    info.setContent("这是内容：" + i);
                    list.add(info);
                }
                listener.onLoadSuccess(0, list);
            }
        }, 2000);
    }

    @Override
    public void loadNextPage(final int currentPage, final OnLoadListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<RecyclerViewInfo> list = new ArrayList<RecyclerViewInfo>();
                for (int i = 0; i < 10; i++) {
                    RecyclerViewInfo info = new RecyclerViewInfo();
                    info.setTitle("这是标题：" + (i + 10 * currentPage));
                    info.setContent("这是内容：" + (i + 10 * currentPage));
                    list.add(info);
                }
                listener.onLoadSuccess(currentPage, list);
            }
        }, 2000);
    }
}