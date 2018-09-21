package dagger.sunhapper.me.baselib.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.sunhapper.me.baselib.activity.BaseImplActivity;

/**
 * Created by sunhapper on 2018/9/21 .
 */
@Module
public abstract class BaseActivitysModule {

    @ContributesAndroidInjector
    abstract BaseImplActivity bindBaseImplActivity();
}
