package me.sunhapper.dagger.mvvm.di.component;

import dagger.Subcomponent;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;
import me.sunhapper.dagger.mvvm.di.scope.MvvmScope;

/**
 * Created by sunhapper on 2018/10/23 .
 */
@MvvmScope
@Subcomponent
public interface MvvmComponent {
    void inject(MeiziTimerActivity meiziTimerActivity);

    @Subcomponent.Builder
    interface Builder {
        MvvmComponent build();
    }
}
