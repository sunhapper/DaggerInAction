package me.sunhapper.dagger.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;
import me.sunhapper.dagger.mvvm.di.component.MvvmComponent;

/**
 * Created by sunhapper on 2018/10/24 .
 */
@Module(subcomponents = MvvmComponent.class)
public abstract class MvvmLibActivitiesModule {


    @ContributesAndroidInjector(modules = {ActivityModule.class, MvvmLibFragmentModule.class})
    abstract MeiziTimerActivity bindFragmentActivity();
}
