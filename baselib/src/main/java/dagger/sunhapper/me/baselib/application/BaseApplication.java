package dagger.sunhapper.me.baselib.application;

import android.app.Application;

import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends Application {
    protected BaseAppComponent baseAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseAppComponent = DaggerBaseAppComponent.builder().baseAppModule(
                new BaseAppModule(this)).build();
    }
}
