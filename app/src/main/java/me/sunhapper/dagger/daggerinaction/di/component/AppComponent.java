package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.sunhapper.me.baselib.di.module.BaseActivitysModule;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;
import dagger.sunhapper.me.baselib.di.scope.AppScope;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.module.ActivitysModule;
import me.sunhapper.dagger.daggerinaction.di.module.AppModule;

/**
 * Created by sunhapper on 2018/9/20 .
 * 使用dependencies实现Component的依赖
 */
@AppScope
@Component(
        modules = {AppModule.class,
                BaseActivitysModule.class,
                AndroidInjectionModule.class,
                BaseAppModule.class,
                AndroidSupportInjectionModule.class,
                ActivitysModule.class})
public interface AppComponent {

    //如果有component使用dependencies，则需要显式声明可以提供的对象
    Integer versionCode();

    void inject(RealApplication application);

    ActivityComponent2 getActivityComponent2();

    ActivityComponent3.Builder getActivityComponent3Builder();
}
