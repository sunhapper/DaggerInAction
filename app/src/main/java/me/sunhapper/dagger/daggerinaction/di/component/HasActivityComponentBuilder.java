package me.sunhapper.dagger.daggerinaction.di.component;

import android.app.Activity;

/**
 * Created by sunhapper on 2018/10/10 .
 */
public interface HasActivityComponentBuilder {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass);
}
