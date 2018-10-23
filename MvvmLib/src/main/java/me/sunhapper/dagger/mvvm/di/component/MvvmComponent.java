package me.sunhapper.dagger.mvvm.di.component;

import com.google.gson.Gson;

import dagger.Component;
import me.sunhapper.dagger.apilib.api.GankApiService;
import me.sunhapper.dagger.apilib.datasource.MeiziDao;
import me.sunhapper.dagger.apilib.di.component.ApiComponent;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;
import me.sunhapper.dagger.mvvm.di.module.ViewModelFactoryModule;
import me.sunhapper.dagger.mvvm.di.module.ViewModelModule;
import me.sunhapper.dagger.mvvm.di.scope.MvvmScope;

/**
 * Created by sunhapper on 2018/10/23 .
 */
@MvvmScope
@Component(dependencies = ApiComponent.class,
        modules = {ViewModelFactoryModule.class,
                ViewModelModule.class})
public interface MvvmComponent {

    void inject(MeiziTimerActivity meiziTimerActivity);

    GankApiService gankApiService();

    MeiziDao meiziDao();

    Integer versionCode();

    Gson gson();

//    ViewModelProvider.Factory viewModelFactory();
}
