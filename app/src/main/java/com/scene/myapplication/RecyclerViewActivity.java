package com.scene.myapplication;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.scene.myapplication.Adapter.MyAdapter;
import com.scene.myapplication.bean.RecyclerViewInfo;
import com.scene.myapplication.presenter.RecyclerViewPresenterImpl;
import com.scene.myapplication.utils.ToastUtil;
import com.scene.myapplication.view.RecyclerViewView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private MyAdapter adapter;
    private List<RecyclerViewInfo> list;


    private RecyclerViewPresenterImpl recyclerViewPresenterImpl;

    private int page = 0;
    private boolean isloading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        recyclerViewPresenterImpl = new RecyclerViewPresenterImpl(RecyclerViewActivity.this);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, list);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);
        loadFirstPage(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (isSlideToBottom(recyclerView)) {
                        if (!isloading) {
                            loadNextPage(page);
                        }
                    }
                }
            }
        });

    }

    @Override
    public void loadFirstPage(boolean isShowProgressBar) {
        isloading = true;
        recyclerViewPresenterImpl.loadFirstPage(isShowProgressBar);
    }

    @Override
    public void loadNextPage(int currentPage) {
        isloading = true;
        recyclerViewPresenterImpl.loadNextPage(page);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showFailInfo() {
        isloading = false;
        swipeRefreshLayout.setRefreshing(false);
        ToastUtil.showToast(RecyclerViewActivity.this, "加载失败");
    }

    @Override
    public void updateRecyclerView(int currentPage, List<RecyclerViewInfo> list) {
        isloading = false;
        swipeRefreshLayout.setRefreshing(false);
        if (currentPage == 0) {
            this.list.clear();
            page=0;
        }
        page++;
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        loadFirstPage(false);
    }

    @Override
    protected void onDestroy() {
        recyclerViewPresenterImpl.onDestory();
        super.onDestroy();
    }

    public static boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }
}
