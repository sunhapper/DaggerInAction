package dagger.sunhapper.me.baselib.di.component;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import dagger.sunhapper.me.baselib.network.LiveDataCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by sunhapper on 2018/10/24 .
 */
public interface BaseAppPublicDependencies {
    Application application();

    Integer versionCode();

    Gson gson();

    Context context();

    RxJava2CallAdapterFactory rxJava2CallAdapterFactory();

    LiveDataCallAdapterFactory liveDataCallAdapterFactory();

    OkHttpClient okHttpClient();
}
