package me.sunhapper.dagger.mvvm.di.module;

import dagger.Module;

/**
 * Created by sunhapper on 2018/10/24 .
 */
@Module(includes = {ViewModelFactoryModule.class, ViewModelModule.class, MvvmLibActivitiesModule.class})
public class MvvmCollectionModule {
}
