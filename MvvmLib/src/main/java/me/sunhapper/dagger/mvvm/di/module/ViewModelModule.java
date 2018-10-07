package me.sunhapper.dagger.mvvm.di.module;

import android.arch.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import me.sunhapper.dagger.mvvm.viewmodel.GankMeiziViewModel;
import me.sunhapper.dagger.mvvm.viewmodel.MeiziTimerViewModel;

/**
 * Created by sunhapper on 2018/9/6 .
 */
@Module
abstract public class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(GankMeiziViewModel.class)
    abstract ViewModel bindGankMeiziViewModel(GankMeiziViewModel viewModel);


    @Binds
    @IntoMap
    @ViewModelKey(MeiziTimerViewModel.class)
    abstract ViewModel bindMeiziTimerViewModel(MeiziTimerViewModel viewModel);
}
