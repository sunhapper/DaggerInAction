package me.sunhapper.dagger.mvvm.activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.sunhapper.me.baselib.activity.BaseActivity;
import me.sunhapper.dagger.mvvm.factory.ViewModelFactory;

/**
 * Created by sunhapper on 2018/9/30 .
 */
public abstract class BaseMvvmActivity<VM extends ViewModel> extends BaseActivity {
    @Inject
    ViewModelFactory mViewModelFactory;
    protected VM mViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        mViewModel = createViewModel();
        super.onCreate(savedInstanceState);
    }

    protected abstract VM createViewModel();


    public <T extends ViewModel> T getViewModel(@NonNull Class<T> modelClass) {
        return getViewModel(modelClass, mViewModelFactory);
    }

    private <T extends ViewModel> T getViewModel(@NonNull Class<T> modelClass,
            @Nullable ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(this, factory).get(modelClass);
    }
}
