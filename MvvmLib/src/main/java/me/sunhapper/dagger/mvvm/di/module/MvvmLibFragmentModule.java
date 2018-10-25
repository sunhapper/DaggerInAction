package me.sunhapper.dagger.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerFragment;
import me.sunhapper.dagger.mvvm.di.component.MvvmComponent;

/**
 * Created by sunhapper on 2018/10/24 .
 */
@Module(subcomponents = MvvmComponent.class)
public abstract class MvvmLibFragmentModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MeiziTimerFragment bindFragmentActivityFragment();

}
