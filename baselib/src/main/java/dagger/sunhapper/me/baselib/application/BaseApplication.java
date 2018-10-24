package dagger.sunhapper.me.baselib.application;

import android.app.Application;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public abstract class BaseApplication extends Application {
//    protected BaseAppComponent baseAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        baseAppComponent = DaggerBaseAppComponent.builder().baseAppModule(
//                new BaseAppModule(this)).build();
    }
}
