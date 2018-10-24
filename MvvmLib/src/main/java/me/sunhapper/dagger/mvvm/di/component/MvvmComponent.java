package me.sunhapper.dagger.mvvm.di.component;

import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;

/**
 * Created by sunhapper on 2018/10/23 .
 */
//@MvvmScope
//@Component(dependencies = ApiComponent.class,
//        modules = {ViewModelFactoryModule.class,
//                ViewModelModule.class})
public interface MvvmComponent extends MvvmPublicDependencies {
    void inject(MeiziTimerActivity meiziTimerActivity);
}
