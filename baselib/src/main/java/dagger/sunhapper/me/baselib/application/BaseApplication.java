package dagger.sunhapper.me.baselib.application;

import android.app.Application;

import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends Application {
    //普通用法
    protected BaseAppComponent mBaseAppComponent;

    @Override
    public void onCreate() {
        mBaseAppComponent = DaggerBaseAppComponent.builder().
                baseAppModule(new BaseAppModule(this))
                .build();
        super.onCreate();

    }

}
