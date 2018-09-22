package dagger.sunhapper.me.baselib.di;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/22 .
 */
public class BaseLibComponentManager {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    Application mApplication;
    private BaseAppComponent mBaseAppComponent;

    private BaseLibComponentManager() {

    }

    private static BaseLibComponentManager singleton = null;

    public static BaseLibComponentManager getInstance() {
        if (singleton == null) {
            synchronized (BaseLibComponentManager.class) {
                if (singleton == null) {
                    singleton = new BaseLibComponentManager();
                }
            }
        }
        return singleton;
    }

    public BaseLibComponentManager init(Application application) {
        mApplication = application;
        mBaseAppComponent = DaggerBaseAppComponent
                .builder()
                .baseAppModule(new BaseAppModule(mApplication))
                .build();
        mBaseAppComponent.inject(this);
        return this;
    }

    public BaseAppComponent getBaseAppComponent() {
        return mBaseAppComponent;
    }

    public void inject(Activity activity){
        activityInjector.inject(activity);
    }
}
