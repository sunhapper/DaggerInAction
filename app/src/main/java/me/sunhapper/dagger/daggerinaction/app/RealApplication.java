package me.sunhapper.dagger.daggerinaction.app;

import javax.inject.Inject;

import dagger.sunhapper.me.baselib.application.BaseApplication;
import me.sunhapper.dagger.daggerinaction.di.component.AppComponent;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerAppComponent;
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
        appComponent = DaggerAppComponent.builder()
                .baseAppComponent(mBaseAppComponent)
                .build();
        appComponent.inject(this);
        Timber.i("onCreate: %s", versionCode);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
