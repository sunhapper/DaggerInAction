package dagger.sunhapper.me.baselib.di.component;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import dagger.sunhapper.me.baselib.di.module.BaseAppModule;
import dagger.sunhapper.me.baselib.di.module.NetworkModule;
import dagger.sunhapper.me.baselib.network.LiveDataCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by sunhapper on 2018/9/19 .
 */
@Component(modules = {BaseAppModule.class, NetworkModule.class})
@Singleton
public interface BaseAppComponent {

    Application application();

    Integer versionCode();

    Gson gson();

    Context context();

    RxJava2CallAdapterFactory rxJava2CallAdapterFactory();

    LiveDataCallAdapterFactory liveDataCallAdapterFactory();

    OkHttpClient okHttpClient();
}
