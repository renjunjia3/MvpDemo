package com.scene.myapplication;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.scene.myapplication.presenter.SaveImagePresenterImpl;
import com.scene.myapplication.utils.ToastUtil;
import com.scene.myapplication.view.SaveImageView;

public class SaveImageActivity extends AppCompatActivity implements SaveImageView, View.OnClickListener {
    private SaveImagePresenterImpl saveImagePresenterImpl;
    private ImageView imageView;
    private ContentLoadingProgressBar progressBar;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image);
        initView();
    }

    private void initView() {
        saveImagePresenterImpl = new SaveImagePresenterImpl(this);

        imageView = (ImageView) findViewById(R.id.image);
        progressBar = (ContentLoadingProgressBar) findViewById(R.id.progressBar);
        save = (Button) findViewById(R.id.save);

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
    protected void onDestroy() {
        saveImagePresenterImpl.destory();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        saveImagePresenterImpl.saveImage(imageView);
    }
}
