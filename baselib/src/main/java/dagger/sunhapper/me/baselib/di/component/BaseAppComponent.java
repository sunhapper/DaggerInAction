package dagger.sunhapper.me.baselib.di.component;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.sunhapper.me.baselib.application.BaseApplication;
import dagger.sunhapper.me.baselib.di.module.ActivitysModule;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/19 .
 */
@Component(modules = {
        ActivitysModule.class,
        AndroidInjectionModule.class,
        BaseAppModule.class,
        AndroidSupportInjectionModule.class})
public interface BaseAppComponent extends AndroidInjector<BaseApplication> {
//    @Component.Builder
//    abstract class Builder extends AndroidInjector.Builder<BaseApplication> {
//    }
}
