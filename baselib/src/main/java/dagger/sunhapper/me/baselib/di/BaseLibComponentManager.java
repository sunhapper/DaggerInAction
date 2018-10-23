package dagger.sunhapper.me.baselib.di;

import android.app.Application;

import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import dagger.sunhapper.me.baselib.di.component.DaggerBaseAppComponent;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;

/**
 * Created by sunhapper on 2018/9/22 .
 */
public class BaseLibComponentManager {

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
        mBaseAppComponent = DaggerBaseAppComponent
                .builder()
                .baseAppModule(new BaseAppModule(application))
                .build();
        return this;
    }

    public BaseAppComponent getBaseAppComponent() {
        return mBaseAppComponent;
    }

}
