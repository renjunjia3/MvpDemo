package com.scene.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.scene.myapplication.presenter.LoginPresenterImpl;
import com.scene.myapplication.utils.ToastUtil;
import com.scene.myapplication.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressBar;

    private LoginPresenterImpl loginPresenterImpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenterImpl = new LoginPresenterImpl(this);
        initView();
    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
        btnClear = (Button) findViewById(R.id.clear);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
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
    public void clearText() {
        etUserName.setText("");
        etPassword.setText("");
    }

    @Override
    public void toNextPage() {
        ToastUtil.showToast(MainActivity.this, "登陆成功");
        startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
    }

    @Override
    public void showErrorInfo() {
        ToastUtil.showToast(MainActivity.this, "登陆失败");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                loginPresenterImpl.login(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
                break;
            case R.id.clear:
                loginPresenterImpl.clear();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        loginPresenterImpl.destory();
        super.onDestroy();
    }
}
