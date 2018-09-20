package me.sunhapper.dagger.daggerinaction.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import me.sunhapper.dagger.daggerinaction.bean.SimpleModuleActivityBean;
import me.sunhapper.dagger.daggerinaction.bean.SimpleModuleBean;
import me.sunhapper.dagger.daggerinaction.di.scope.SimpleScope;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@Module
public class SimpleModule {

    private Activity mActivity;

    public SimpleModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @SimpleScope
    public SimpleModuleBean provideSimpleModuleBean() {
        return new SimpleModuleBean();
    }

    @Provides
    public SimpleModuleActivityBean provideSimpleModuleActivityBean() {
        return new SimpleModuleActivityBean(mActivity);
    }
}
