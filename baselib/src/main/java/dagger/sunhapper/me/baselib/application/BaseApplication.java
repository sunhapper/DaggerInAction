package dagger.sunhapper.me.baselib.application;

import android.app.Application;

import dagger.android.HasActivityInjector;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends Application implements HasActivityInjector {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
