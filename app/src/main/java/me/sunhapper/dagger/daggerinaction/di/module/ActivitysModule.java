package me.sunhapper.dagger.daggerinaction.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.sunhapper.dagger.daggerinaction.activity.DaggerAndroidActivity;

/**
 * Created by sunhapper on 2018/9/21 .
 */
@Module
public abstract class ActivitysModule {

    @ContributesAndroidInjector
    abstract DaggerAndroidActivity bindDaggerAndroidActivity();
}
