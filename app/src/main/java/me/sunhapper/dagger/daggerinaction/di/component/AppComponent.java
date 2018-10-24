package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.sunhapper.me.baselib.di.module.BaseAppCollectionModule;
import dagger.sunhapper.me.baselib.di.scope.AppScope;
import me.sunhapper.dagger.apilib.di.module.ApiCollectionModule;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.module.AppModule;
import me.sunhapper.dagger.mvvm.di.module.MvvmCollectionModule;
import me.sunhapper.dagger.mvvm.di.module.MvvmLibActivitiesModule;

/**
 * Created by sunhapper on 2018/9/20 .
 * 使用dependencies实现Component的依赖
 */
@AppScope
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BaseAppCollectionModule.class,
        ApiCollectionModule.class,
        MvvmCollectionModule.class,
        MvvmLibActivitiesModule.class
})
public interface AppComponent {

    void inject(RealApplication application);

}
