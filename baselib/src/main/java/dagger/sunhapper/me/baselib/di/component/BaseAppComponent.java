package dagger.sunhapper.me.baselib.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.sunhapper.me.baselib.di.BaseLibComponentManager;
import dagger.sunhapper.me.baselib.di.module.BaseActivitysModule;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
@Component(modules = {
        BaseActivitysModule.class,
        AndroidInjectionModule.class,
        BaseAppModule.class,
        AndroidSupportInjectionModule.class})
@Singleton
public interface BaseAppComponent extends AndroidInjector<BaseLibComponentManager> {
    Application application();
    Integer versionCode();
}
