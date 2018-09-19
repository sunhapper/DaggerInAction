package dagger.sunhapper.me.baselib.application;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerBaseAppComponent.builder().
                baseAppModule(new BaseAppModule(this))
                .build();
    }
}
