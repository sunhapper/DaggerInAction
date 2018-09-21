package dagger.sunhapper.me.baselib.application;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends Application implements HasActivityInjector {
    //普通用法
    protected BaseAppComponent mBaseAppComponent;
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        mBaseAppComponent = DaggerBaseAppComponent.builder().
                baseAppModule(new BaseAppModule(this))
                .build();
        mBaseAppComponent.inject(this);
        super.onCreate();

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
