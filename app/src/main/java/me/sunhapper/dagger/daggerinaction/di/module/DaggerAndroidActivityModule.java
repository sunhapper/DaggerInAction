package me.sunhapper.dagger.daggerinaction.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;

/**
 * Created by sunhapper on 2018/10/10 .
 */
@Module
public class DaggerAndroidActivityModule {
    @Provides
    @ActivityScope
    @Named(value = "ActivityName")
    String provideDaggerAndroidActivityName() {
        return "DaggerAndroidActivity";
    }
}
