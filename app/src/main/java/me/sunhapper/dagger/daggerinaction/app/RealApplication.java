package me.sunhapper.dagger.daggerinaction.app;

import android.app.Activity;
import android.content.Context;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.sunhapper.me.baselib.application.BaseApplication;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;
import me.sunhapper.dagger.daggerinaction.di.component.ActivityComponentBuilder;
import me.sunhapper.dagger.daggerinaction.di.component.AppComponent;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerAppComponent;
import me.sunhapper.dagger.daggerinaction.di.component.HasActivityComponentBuilder;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public class RealApplication extends BaseApplication implements HasActivityInjector, HasActivityComponentBuilder {
    private static final String TAG = "RealApplication";
    @Inject
    Integer versionCode;
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Inject
    Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> activityComponentBuilders;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        Timber.plant(new Timber.DebugTree());
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .baseAppModule(new BaseAppModule(this))
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

    public static HasActivityComponentBuilder get(Context context) {
        return ((HasActivityComponentBuilder) context.getApplicationContext());
    }


    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass) {
        return activityComponentBuilders.get(activityClass).get();
    }
}
