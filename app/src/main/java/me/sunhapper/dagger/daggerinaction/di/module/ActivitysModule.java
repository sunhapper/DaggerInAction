package me.sunhapper.dagger.daggerinaction.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;
import me.sunhapper.dagger.daggerinaction.activity.DaggerAndroidActivity;

/**
 * Created by sunhapper on 2018/9/21 .
 */
@Module
public abstract class ActivitysModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = DaggerAndroidActivityModule.class)
    abstract DaggerAndroidActivity bindDaggerAndroidActivity();
}
