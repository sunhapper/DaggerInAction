package me.sunhapper.dagger.daggerinaction.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.sunhapper.me.daggerinaction.R;
import me.sunhapper.dagger.daggerinaction.app.RealApplication;
import me.sunhapper.dagger.daggerinaction.di.component.ActivityComponent3;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SubComponentActivity3 extends BaseAppActivity {
    private TextView mTvInfo;
    @Inject
    Integer versionCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectMembers();
        setContentView(R.layout.activity_sub_component);
        initView();
        mTvInfo.setText(String.valueOf(versionCode));
    }


    private void injectMembers() {
        RealApplication.get(this).getActivityComponentBuilder(SubComponentActivity3.class)
                .activityModule(new ActivityComponent3.SubcomponentActivityModule(this))
                .build()
                .injectMembers(this);
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }
}
