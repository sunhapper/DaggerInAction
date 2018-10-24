package me.sunhapper.dagger.mvvm.di.component;

import dagger.Component;
import me.sunhapper.dagger.apilib.di.component.ApiComponent;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;
import me.sunhapper.dagger.mvvm.di.module.ViewModelFactoryModule;
import me.sunhapper.dagger.mvvm.di.module.ViewModelModule;
import me.sunhapper.dagger.mvvm.di.scope.MvvmScope;

/**
 * Created by sunhapper on 2018/10/23 .
 */
@MvvmScope
@Component(dependencies = ApiComponent.class,
        modules = {ViewModelFactoryModule.class,
                ViewModelModule.class})
public interface MvvmComponent extends MvvmPublicDependencies {
    void inject(MeiziTimerActivity meiziTimerActivity);
}
