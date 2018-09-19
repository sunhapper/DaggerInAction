package dagger.sunhapper.me.baselib.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.sunhapper.me.baselib.activity.BaseImplActivity;

/**
 * Created by sunhapper(haipeng.sun3@56qq.com) on 2018/8/17 .
 */
@Module
public abstract class ActivitysModule {

    @ContributesAndroidInjector
    abstract BaseImplActivity contributeMainActivitytInjector();

}