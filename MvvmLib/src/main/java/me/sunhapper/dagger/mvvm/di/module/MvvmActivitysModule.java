package me.sunhapper.dagger.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.sunhapper.dagger.mvvm.activity.MvvmActivity;

/**
 * Created by sunhapper on 2018/9/30 .
 */
@Module
public abstract class MvvmActivitysModule {
    @ContributesAndroidInjector
    abstract MvvmActivity contributeMvvmActivityInjector();
}
