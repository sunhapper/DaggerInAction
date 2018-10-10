package me.sunhapper.dagger.daggerinaction.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.sunhapper.me.daggerinaction.R;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SubComponentActivity2 extends BaseAppActivity {
    private TextView mTvInfo;
    @Inject
    Integer versionCode;
    @Inject
    @Named(value = "AppName")
    String appName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppCompoent().getActivityComponent2().inject(this);
        setContentView(R.layout.activity_sub_component);
        initView();
        mTvInfo.setText(String.valueOf(versionCode) + " " + appName);
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }
}
