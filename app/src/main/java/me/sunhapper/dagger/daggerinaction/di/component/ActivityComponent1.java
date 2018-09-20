package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Component;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;
import me.sunhapper.dagger.daggerinaction.activity.SubComponentActivity1;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent1 {
    void inject(SubComponentActivity1 activity);
}
