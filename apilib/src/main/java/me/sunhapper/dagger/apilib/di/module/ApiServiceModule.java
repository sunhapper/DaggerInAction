package me.sunhapper.dagger.apilib.di.module;

import static me.sunhapper.dagger.apilib.common.Constants.GANK_IO_HOST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.sunhapper.dagger.apilib.api.GankApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunhapper on 2018/9/29 .
 */
@Module
public class ApiServiceModule {
    @Singleton
    @Provides
    public GankApiService provideGankApiService(OkHttpClient client, RxJava2CallAdapterFactory callAdapterFactory) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z").create();
        GsonConverterFactory factory = GsonConverterFactory.create(gson);
        return new Retrofit.Builder()
                .baseUrl(GANK_IO_HOST)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(callAdapterFactory)
                .build().create(GankApiService.class);
    }
}
