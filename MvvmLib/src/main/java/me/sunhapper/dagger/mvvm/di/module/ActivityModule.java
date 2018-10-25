package me.sunhapper.dagger.mvvm.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunhapper on 2018/10/25 .
 */
@Module
public class ActivityModule {


    @Provides
    @Named(value = "activity")
    public String provideViewName() {
        return "activity";
    }
}
