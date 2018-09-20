package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Component;
import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.scope.AppScope;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.module.AppModule;

/**
 * Created by sunhapper on 2018/9/20 .
 * 使用dependencies实现Component的依赖
 */
@AppScope
@Component(dependencies = BaseAppComponent.class, modules = AppModule.class)
public interface AppComponent {

    Integer versionCode();

    void inject(RealApplication application);

    ActivityComponent2 getActivityComponent2();

    ActivityComponent3.Builder getActivityComponent3Builder();
}
