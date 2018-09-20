package me.sunhapper.dagger.daggerinaction.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.sunhapper.me.daggerinaction.R;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerActivityComponent1;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SubComponentActivity1 extends BaseAppActivity {
    private TextView mTvInfo;
    @Inject
    Integer versionCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerActivityComponent1.builder()
                .appComponent(getAppCompoent())
                .build().inject(this);
        setContentView(R.layout.activity_sub_component);
        initView();
        mTvInfo.setText(String.valueOf(versionCode));
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }
}
