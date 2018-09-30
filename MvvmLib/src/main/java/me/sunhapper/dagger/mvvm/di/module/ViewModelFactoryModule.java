package me.sunhapper.dagger.mvvm.di.module;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import me.sunhapper.dagger.mvvm.factory.ViewModelFactory;

@Module(includes = ViewModelModule.class)
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
