package me.sunhapper.dagger.daggerinaction.activity;

import dagger.sunhapper.me.baselib.activity.BaseActivity;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.component.AppComponent;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public abstract class BaseAppActivity extends BaseActivity {
    AppComponent getAppCompoent() {
        RealApplication realApplication = (RealApplication) getApplication();
        return realApplication.getAppComponent();
    }
}
