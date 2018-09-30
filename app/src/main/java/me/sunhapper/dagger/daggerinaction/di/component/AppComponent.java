package me.sunhapper.dagger.daggerinaction.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.sunhapper.me.baselib.di.module.BaseActivitysModule;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;
import dagger.sunhapper.me.baselib.di.module.NetworkModule;
import me.sunhapper.dagger.apilib.di.module.ApiServiceModule;
import me.sunhapper.dagger.apilib.di.module.OrmModule;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.module.ActivitysModule;
import me.sunhapper.dagger.daggerinaction.di.module.AppModule;
import me.sunhapper.dagger.mvvm.di.module.MvvmActivitysModule;
import me.sunhapper.dagger.mvvm.di.module.ViewModelFactoryModule;
import me.sunhapper.dagger.mvvm.di.module.ViewModelModule;

/**
 * Created by sunhapper on 2018/9/20 .
 * 使用dependencies实现Component的依赖
 */
@Singleton
@Component(
        modules = {
                //from dagger.android
                AndroidInjectionModule.class,
                AndroidSupportInjectionModule.class,
                //from app
                AppModule.class,
                ActivitysModule.class,
                //from baselib
                BaseAppModule.class,
                BaseActivitysModule.class,
                NetworkModule.class,
                //from apilib
                OrmModule.class,
                ApiServiceModule.class,
                //from mvvmlib
                MvvmActivitysModule.class,
                ViewModelFactoryModule.class,
                ViewModelModule.class})
public interface AppComponent {

    //如果有component使用dependencies，则需要显式声明可以提供的对象
    Integer versionCode();

    void inject(RealApplication application);

    ActivityComponent2 getActivityComponent2();

    ActivityComponent3.Builder getActivityComponent3Builder();
}
