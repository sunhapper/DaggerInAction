package me.sunhapper.dagger.daggerinaction.di.module;

import dagger.Module;
import dagger.Provides;
import dagger.sunhapper.me.baselib.di.scope.ActivityScope;

@Module
public abstract class ActivityModule<T> {
    protected final T activity;

    public ActivityModule(T activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public T provideActivity() {
        return activity;
    }
}
