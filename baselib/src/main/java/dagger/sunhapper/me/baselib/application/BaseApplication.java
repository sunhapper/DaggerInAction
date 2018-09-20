package dagger.sunhapper.me.baselib.application;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends DaggerApplication {
    //普通用法
    private BaseAppComponent mBaseAppComponent;

    @Override
    public void onCreate() {
        mBaseAppComponent = DaggerBaseAppComponent.builder().
                baseAppModule(new BaseAppModule(this))
                .build();
        super.onCreate();

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        //dagger.android的用法
        return mBaseAppComponent;
    }
}
