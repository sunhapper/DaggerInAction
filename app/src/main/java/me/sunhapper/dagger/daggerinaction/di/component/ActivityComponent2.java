package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Subcomponent;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;
import me.sunhapper.dagger.daggerinaction.activity.SubComponentActivity2;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@ActivityScope
@Subcomponent
public interface ActivityComponent2 {
    void inject(SubComponentActivity2 activity);
}
