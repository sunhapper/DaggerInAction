package me.sunhapper.dagger.daggerinaction.app;

import javax.inject.Inject;

import dagger.sunhapper.me.baselib.application.BaseApplication;
import me.sunhapper.dagger.apilib.di.ApiLibComponentManager;
import me.sunhapper.dagger.apilib.di.component.ApiComponent;
import me.sunhapper.dagger.daggerinaction.di.component.AppComponent;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerAppComponent;
import me.sunhapper.dagger.mvvm.di.MvvmLibComponentManager;
import me.sunhapper.dagger.mvvm.di.component.MvvmComponent;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public class RealApplication extends BaseApplication {
    private static final String TAG = "RealApplication";
    @Inject
    Integer versionCode;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        Timber.plant(new Timber.DebugTree());
        super.onCreate();
        ApiComponent apiComponent = ApiLibComponentManager.getInstance().init(baseAppComponent).getApiComponent();
        MvvmComponent mvvmComponent = MvvmLibComponentManager.getInstance().init(apiComponent).getMvvmComponent();
        appComponent = DaggerAppComponent.builder()
                .mvvmComponent(mvvmComponent)
                .build();
        appComponent.inject(this);
        Timber.i("onCreate: %s", versionCode);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
