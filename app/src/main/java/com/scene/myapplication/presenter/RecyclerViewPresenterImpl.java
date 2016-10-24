package com.scene.myapplication.presenter;


import com.scene.myapplication.bean.RecyclerViewInfo;
import com.scene.myapplication.model.RecyclerViewModel;
import com.scene.myapplication.model.RecyclerViewModelImpl;
import com.scene.myapplication.view.RecyclerViewView;

import java.util.List;

/**
 * Created by MVPHelper on 2016/10/21
 */

public class RecyclerViewPresenterImpl implements RecyclerViewPresenter, RecyclerViewModel.OnLoadListener {
    private RecyclerViewView recyclerViewView;

    private RecyclerViewModelImpl recyclerViewModelImpl;

    public RecyclerViewPresenterImpl(RecyclerViewView recyclerViewView) {
        this.recyclerViewView = recyclerViewView;
        recyclerViewModelImpl = new RecyclerViewModelImpl();
    }

    @Override
    public void loadFirstPage(boolean isShowProgressBar) {
        if (recyclerViewView != null) {
            if (isShowProgressBar) {
                recyclerViewView.showProgressBar();
            }
            recyclerViewModelImpl.loadFirstPage(this);
        }
    }

    @Override
    public void loadNextPage(int currentPage) {
        if (recyclerViewView != null) {
            recyclerViewModelImpl.loadNextPage(currentPage, this);
        }
    }

    @Override
    public void onLoadSuccess(int currentPage,List<RecyclerViewInfo> list) {
        if (recyclerViewView != null) {
            recyclerViewView.hideProgressBar();
            recyclerViewView.updateRecyclerView(currentPage,list);
        }
    }

    @Override
    public void onLoadFail() {
        if (recyclerViewView != null) {
            recyclerViewView.hideProgressBar();
            recyclerViewView.showFailInfo();
        }
    }

    public void onDestory() {
        recyclerViewView = null;
    }
}