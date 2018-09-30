package dagger.sunhapper.me.baselib.di.module;

import android.content.Context;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.sunhapper.me.baselib.network.LogInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by sunhapper on 2018/9/4 .
 */
@Module
public class NetworkModule {
    private static final int DEFAULT_TIME_OUT = 15;


    @Singleton
    @Provides
    public PersistentCookieJar provideCookieJar(Context context) {
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(PersistentCookieJar cookieJar) {
        return new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .build();

    }

    @Singleton
    @Provides
    public RxJava2CallAdapterFactory provideRxJavaRetrofitCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }


}
