package me.sunhapper.dagger.daggerinaction.di.component;

import dagger.Component;
import me.sunhapper.dagger.daggerinaction.activity.SimpleActivity;
import me.sunhapper.dagger.daggerinaction.di.scope.SimpleScope;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@Component
@SimpleScope
public interface SimpleComponent {
    void inject(SimpleActivity simpleActivity);
}
