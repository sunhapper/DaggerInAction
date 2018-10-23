package me.sunhapper.dagger.mvvm.di;

import me.sunhapper.dagger.apilib.di.component.ApiComponent;
import me.sunhapper.dagger.mvvm.di.component.DaggerMvvmComponent;
import me.sunhapper.dagger.mvvm.di.component.MvvmComponent;

/**
 * Created by sunhapper on 2018/9/22 .
 */
public class MvvmLibComponentManager {

    private MvvmComponent mMvvmComponent;

    private MvvmLibComponentManager() {

    }

    private static MvvmLibComponentManager singleton = null;

    public static MvvmLibComponentManager getInstance() {
        if (singleton == null) {
            synchronized (MvvmLibComponentManager.class) {
                if (singleton == null) {
                    singleton = new MvvmLibComponentManager();
                }
            }
        }
        return singleton;
    }

    public MvvmLibComponentManager init(ApiComponent apiComponent) {
        mMvvmComponent = DaggerMvvmComponent
                .builder()
                .apiComponent(apiComponent)
                .build();
        return this;
    }

    public MvvmComponent getMvvmComponent() {
        return mMvvmComponent;
    }

}
