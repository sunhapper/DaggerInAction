package me.sunhapper.dagger.daggerinaction.app;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.sunhapper.me.baselib.application.BaseApplication;
import dagger.sunhapper.me.baselib.di.BaseLibComponentManager;
import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import me.sunhapper.dagger.daggerinaction.di.component.AppComponent;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public class RealApplication extends BaseApplication implements HasActivityInjector {
    private static final String TAG = "RealApplication";
    @Inject
    Integer versionCode;
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    private AppComponent appComponent;
    private BaseAppComponent mBaseAppComponent;

    @Override
    public void onCreate() {
        Timber.plant(new Timber.DebugTree());
        super.onCreate();
        mBaseAppComponent = BaseLibComponentManager
                .getInstance()
                .init(this)
                .getBaseAppComponent();
        appComponent = DaggerAppComponent.builder()
                .baseAppComponent(mBaseAppComponent)
                .build();
        appComponent.inject(this);
        Timber.i("onCreate: %s", versionCode);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
