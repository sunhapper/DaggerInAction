package me.sunhapper.dagger.daggerinaction.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import me.sunhapper.dagger.daggerinaction.di.component.ActivityComponent3;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@Module(subcomponents = ActivityComponent3.class)
public class AppModule {
    @Provides
    @Named(value = "AppName")
    String provideAppName() {
        return "DaggerInAction";
    }
}
