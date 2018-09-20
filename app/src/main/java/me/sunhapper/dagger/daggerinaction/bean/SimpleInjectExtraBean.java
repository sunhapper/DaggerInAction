package me.sunhapper.dagger.daggerinaction.bean;

import javax.inject.Inject;

import me.sunhapper.dagger.daggerinaction.di.scope.SimpleScope;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@SimpleScope
public class SimpleInjectExtraBean {
    @Inject
    public SimpleInjectExtraBean() {
    }
}
