package me.sunhapper.dagger.apilib.di.module;

import dagger.Module;

/**
 * Created by sunhapper on 2018/10/24 .
 */
@Module(includes = {ApiServiceModule.class, OrmModule.class})
public class ApiCollectionModule {
}
