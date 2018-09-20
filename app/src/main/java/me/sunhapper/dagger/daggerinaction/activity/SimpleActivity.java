package me.sunhapper.dagger.daggerinaction.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.sunhapper.me.daggerinaction.R;
import me.sunhapper.dagger.daggerinaction.bean.SimpleInjectBean;
import me.sunhapper.dagger.daggerinaction.bean.SimpleInjectExtraBean;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerSimpleComponent;
import me.sunhapper.dagger.daggerinaction.di.component.SimpleComponent;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SimpleActivity extends AppCompatActivity {
    @Inject
    SimpleInjectBean mSimpleInjectBean;
    @Inject
    SimpleInjectExtraBean mSimpleInjectExtraBean;
    private TextView mTvInfo;
    private SimpleComponent mSimpleComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mSimpleComponent = DaggerSimpleComponent.create();
        mSimpleComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initView();
        mTvInfo.setText(
                String.format("%s\n%s\n%s", mSimpleInjectBean, mSimpleInjectBean.mSimpleInjectExtraBean,
                        mSimpleInjectExtraBean));
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }
}
