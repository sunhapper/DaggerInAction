package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Subcomponent;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;
import me.sunhapper.dagger.daggerinaction.activity.SubComponentActivity3;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@ActivityScope
@Subcomponent
public interface ActivityComponent3 {
    void inject(SubComponentActivity3 activity);

    //在module中指定subcomponents的Component必须显式地声明 Subcomponent.Builder
    @Subcomponent.Builder
    interface Builder {
        ActivityComponent3 build();
    }
}
