package dagger.sunhapper.me.baselib.di.module;

import dagger.Module;

/**
 * Created by sunhapper on 2018/10/24 .
 */
@Module(includes = {BaseAppModule.class, NetworkModule.class})
public class BaseAppCollectionModule {
}
