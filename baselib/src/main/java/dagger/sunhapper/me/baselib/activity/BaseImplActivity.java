package dagger.sunhapper.me.baselib.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.sunhapper.me.baselib.di.BaseLibComponentManager;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/21 .
 */
public class BaseImplActivity extends BaseActivity {

    @Inject
    Integer versionCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseLibComponentManager.getInstance().inject(this);
        Timber.i("onCreate: %s", versionCode);
    }
}
