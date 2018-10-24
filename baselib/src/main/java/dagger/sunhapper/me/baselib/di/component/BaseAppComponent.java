package dagger.sunhapper.me.baselib.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;
import dagger.sunhapper.me.baselib.di.module.NetworkModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
@Component(modules = {BaseAppModule.class, NetworkModule.class})
@Singleton
public interface BaseAppComponent extends BaseAppPublicDependencies {


}
