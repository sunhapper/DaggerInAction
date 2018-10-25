package me.sunhapper.dagger.mvvm.di.component;

import dagger.Subcomponent;
import me.sunhapper.dagger.mvvm.view.InjectionView;

/**
 * Created by sunhapper on 2018/10/25 .
 */
@Subcomponent
public interface MvvmViewComponent {
    void inject(InjectionView injectionView);

    @Subcomponent.Builder
    interface Builder {
        MvvmViewComponent build();
    }
}
