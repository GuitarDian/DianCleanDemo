package com.dian.mycleandemo.presentation.base;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

import com.dian.mycleandemo.presentation.util.L;

/**
 * Created by Dian on 2018/9/19.
 */
public abstract class BaseApp extends Application implements ActivityLifecycleCallbacks {

    private static BaseApp INSTANCE;
    public static BaseApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        INSTANCE = this;
        init();
    }

    protected abstract void init();

    public static Context getContext() {
        return INSTANCE.getApplicationContext();
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        L.v(activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStarted(Activity activity) {
        L.v(activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        L.v(activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        L.v(activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        L.v(activity.getClass().getSimpleName());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        L.v(activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        L.v(activity.getClass().getSimpleName());
    }
}
