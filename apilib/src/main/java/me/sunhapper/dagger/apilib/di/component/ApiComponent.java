package me.sunhapper.dagger.apilib.di.component;

import android.app.Application;

import com.google.gson.Gson;

import dagger.Component;
import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import me.sunhapper.dagger.apilib.api.GankApiService;
import me.sunhapper.dagger.apilib.datasource.MeiziDao;
import me.sunhapper.dagger.apilib.di.module.ApiServiceModule;
import me.sunhapper.dagger.apilib.di.module.OrmModule;
import me.sunhapper.dagger.apilib.di.scope.ApiScope;

/**
 * Created by sunhapper on 2018/10/23 .
 */
@ApiScope
@Component(dependencies = BaseAppComponent.class,
        modules = {OrmModule.class,
                ApiServiceModule.class})
public interface ApiComponent {
    GankApiService gankApiService();

    MeiziDao meiziDao();

    Integer versionCode();

    Gson gson();

    Application application();
}
