package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Component;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.module.AppModule;
import me.sunhapper.dagger.daggerinaction.di.scope.AppScope;
import me.sunhapper.dagger.mvvm.di.component.MvvmComponent;

/**
 * Created by sunhapper on 2018/9/20 .
 * 使用dependencies实现Component的依赖
 */
@AppScope
@Component(dependencies = MvvmComponent.class,
        modules = {AppModule.class})
public interface AppComponent {

    //如果有component使用dependencies，则需要显式声明可以提供的对象
    Integer versionCode();

    void inject(RealApplication application);

}
