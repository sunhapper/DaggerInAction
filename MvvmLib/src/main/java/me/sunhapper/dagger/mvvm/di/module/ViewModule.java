package me.sunhapper.dagger.mvvm.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import me.sunhapper.dagger.mvvm.di.component.MvvmViewComponent;

/**
 * Created by sunhapper on 2018/10/25 .
 */
@Module(subcomponents = MvvmViewComponent.class)
public class ViewModule {


    @Provides
    @Named(value = "view")
    public String provideViewName() {
        return "View";
    }
}
