package me.sunhapper.dagger.daggerinaction.di.component;

import me.sunhapper.dagger.daggerinaction.di.module.ActivityModule;

/**
 * Created by sunhapper on 2018/10/10 .
 */
public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityInjector> {
    ActivityComponentBuilder<M, C> activityModule(M activityModule);

    C build();
}
