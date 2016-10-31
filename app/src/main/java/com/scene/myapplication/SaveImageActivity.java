package com.scene.myapplication;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.scene.myapplication.presenter.SaveImagePresenterImpl;
import com.scene.myapplication.utils.ToastUtil;
import com.scene.myapplication.view.SaveImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SaveImageActivity extends AppCompatActivity implements SaveImageView, View.OnClickListener {
    @BindView(R.id.save)
    Button save;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.progressBar)
    ContentLoadingProgressBar progressBar;

    private SaveImagePresenterImpl saveImagePresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        saveImagePresenterImpl = new SaveImagePresenterImpl(this);
        save.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorInfo(String str) {
        ToastUtil.showToast(this, str);
    }

    @Override
    public void showSuccessInfo() {
        ToastUtil.showToast(this, "成功");
    }

    @Override
    public void onClick(View v) {
        saveImagePresenterImpl.saveImage(image);
    }

    @Override
    protected void onDestroy() {
        saveImagePresenterImpl.destory();
        super.onDestroy();
    }
}
