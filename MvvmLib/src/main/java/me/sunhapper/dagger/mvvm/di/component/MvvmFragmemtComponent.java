package me.sunhapper.dagger.mvvm.di.component;

import dagger.Subcomponent;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerFragment;

/**
 * Created by sunhapper on 2018/10/25 .
 */
@Subcomponent
public interface MvvmFragmemtComponent {
    void inject(MeiziTimerFragment fragment);

    @Subcomponent.Builder
    interface Builder {
        MvvmFragmemtComponent build();
    }
}
