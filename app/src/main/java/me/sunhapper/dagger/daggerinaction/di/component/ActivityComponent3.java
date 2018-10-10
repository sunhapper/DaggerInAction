package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Module;
import dagger.Subcomponent;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;
import me.sunhapper.dagger.daggerinaction.activity.SubComponentActivity3;
import me.sunhapper.dagger.daggerinaction.di.module.ActivityModule;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@ActivityScope
@Subcomponent(modules = ActivityComponent3.SubcomponentActivityModule.class)
public interface ActivityComponent3 extends ActivityInjector<SubComponentActivity3> {


    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SubcomponentActivityModule, ActivityComponent3> {
    }

    @Module
    class SubcomponentActivityModule extends ActivityModule<SubComponentActivity3> {
        public SubcomponentActivityModule(SubComponentActivity3 activity) {
            super(activity);
        }
    }
}
