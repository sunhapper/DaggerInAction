package me.sunhapper.dagger.apilib.di;

import dagger.sunhapper.me.baselib.di.component.BaseAppComponent;
import me.sunhapper.dagger.apilib.di.component.ApiComponent;
import me.sunhapper.dagger.apilib.di.component.DaggerApiComponent;

/**
 * Created by sunhapper on 2018/9/22 .
 */
public class ApiLibComponentManager {

    private ApiComponent mApiComponent;

    private ApiLibComponentManager() {

    }

    private static ApiLibComponentManager singleton = null;

    public static ApiLibComponentManager getInstance() {
        if (singleton == null) {
            synchronized (ApiLibComponentManager.class) {
                if (singleton == null) {
                    singleton = new ApiLibComponentManager();
                }
            }
        }
        return singleton;
    }

    public ApiLibComponentManager init(BaseAppComponent baseAppComponent) {
        mApiComponent = DaggerApiComponent
                .builder()
                .baseAppComponent(baseAppComponent)
                .build();
        return this;
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

}
