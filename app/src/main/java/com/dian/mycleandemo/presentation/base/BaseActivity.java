package com.dian.mycleandemo.presentation.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dian on 2018/9/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Unbinder unbinder;
    protected BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        unbinder = ButterKnife.bind(this);
        basePresenter = genPresenter();
        if (basePresenter != null)
            basePresenter.attachView(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        if (basePresenter != null) {
            basePresenter.detach();
            basePresenter.detachView();
            basePresenter = null;
        }
        unbinder.unbind();
        super.onDestroy();
    }

    protected abstract void bindView();

    protected abstract void initData();

    protected abstract BasePresenter genPresenter();
}
