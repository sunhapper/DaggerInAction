package me.sunhapper.dagger.daggerinaction.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.multibindings.IntoMap;
import me.sunhapper.dagger.daggerinaction.activity.SubComponentActivity3;
import me.sunhapper.dagger.daggerinaction.di.component.ActivityComponent3;
import me.sunhapper.dagger.daggerinaction.di.component.ActivityComponentBuilder;

/**
 * Created by sunhapper on 2018/10/10 .
 */
@Module(subcomponents = ActivityComponent3.class)
public abstract class ActivitisMultibindingModule {
    @Binds
    @IntoMap
    @ActivityKey(SubComponentActivity3.class)
    public abstract ActivityComponentBuilder
    bindSubComponentActivityBuilder(ActivityComponent3.Builder builder);
}
