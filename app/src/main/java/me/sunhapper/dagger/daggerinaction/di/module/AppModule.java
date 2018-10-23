package me.sunhapper.dagger.daggerinaction.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@Module
public class AppModule {
    @Provides
    @Named(value = "AppName")
    String provideAppName() {
        return "DaggerInAction";
    }
}
