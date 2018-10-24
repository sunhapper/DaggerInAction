package me.sunhapper.dagger.apilib.di.component;

import dagger.sunhapper.me.baselib.di.component.BaseAppPublicDependencies;
import me.sunhapper.dagger.apilib.api.GankApiService;
import me.sunhapper.dagger.apilib.datasource.MeiziDao;

/**
 * Created by sunhapper on 2018/10/24 .
 */
public interface ApiPublicDependencies extends BaseAppPublicDependencies {
    GankApiService gankApiService();

    MeiziDao meiziDao();
}
