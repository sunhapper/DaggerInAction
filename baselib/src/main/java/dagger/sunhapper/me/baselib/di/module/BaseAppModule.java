package dagger.sunhapper.me.baselib.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import dagger.sunhapper.me.baselib.BuildConfig;
import dagger.sunhapper.me.baselib.di.scope.AppScope;

/**
 * Created by sunhapper on 2018/9/19 .
 */
@Module
public class BaseAppModule {
    private Application mApplication;

    public BaseAppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @AppScope
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @AppScope
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    Integer provideVersion() {
        return BuildConfig.VERSION_CODE;
    }
}
