package me.sunhapper.dagger.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;

/**
 * Created by sunhapper on 2018/10/24 .
 */
@Module
public abstract class MvvmLibActivitiesModule {
    @ContributesAndroidInjector
    abstract MeiziTimerActivity bindMeiziTimerActivity();
}
