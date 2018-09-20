package me.sunhapper.dagger.daggerinaction.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;
import dagger.sunhapper.me.daggerinaction.R;
import me.sunhapper.dagger.daggerinaction.bean.SimpleActivityBean;
import me.sunhapper.dagger.daggerinaction.bean.SimpleInjectBean;
import me.sunhapper.dagger.daggerinaction.bean.SimpleInjectExtraBean;
import me.sunhapper.dagger.daggerinaction.bean.SimpleModuleActivityBean;
import me.sunhapper.dagger.daggerinaction.bean.SimpleModuleBean;
import me.sunhapper.dagger.daggerinaction.di.component.DaggerSimpleComponent;
import me.sunhapper.dagger.daggerinaction.di.component.SimpleComponent;
import me.sunhapper.dagger.daggerinaction.di.module.SimpleModule;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SimpleActivity extends AppCompatActivity {
    @Inject
    SimpleInjectBean mSimpleInjectBean;
    @Inject
    SimpleInjectExtraBean mSimpleInjectExtraBean;
    @Inject
    SimpleModuleActivityBean mSimpleModuleActivityBean;
    @Inject
    SimpleActivityBean mSimpleActivityBean;
    @Inject
    SimpleModuleBean mSimpleModuleBean;
    @Inject
    Lazy<SimpleInjectBean> mSimpleInjectBeanLazy;
    @Inject
    Lazy<SimpleModuleBean> mSimpleModuleBeanLazy;
    @Inject
    Provider<SimpleInjectBean> mSimpleInjectBeanProvider;
    @Inject
    Provider<SimpleModuleBean> mSimpleModuleBeanProvider;
    private TextView mTvInfo;
    private SimpleComponent mSimpleComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mSimpleComponent = DaggerSimpleComponent.builder()
                .simpleActivity(this)
                .simpleModule(new SimpleModule(this))
                .build();
        mSimpleComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initView();
        String step1 = String.format("%s\n%s\n%s\n\n%s\n%s\n\n%s\n%s\n\n", mSimpleInjectBean,
                mSimpleInjectBean.mSimpleInjectExtraBean,
                mSimpleInjectExtraBean, mSimpleModuleBean, mSimpleInjectBean.mSimpleModuleBean,
                mSimpleModuleActivityBean, mSimpleActivityBean);
        String step2 = "Lazy:\n" + mSimpleInjectBeanLazy.get() + "\n" + mSimpleInjectBeanLazy.get() + "\n"
                + mSimpleModuleBeanLazy.get() + "\n" + mSimpleModuleBeanLazy.get() + "\n";
        String step3 = "Provider:\n" + mSimpleInjectBeanProvider.get() + "\n" + mSimpleInjectBeanProvider.get() + "\n"
                + mSimpleModuleBeanProvider.get() + "\n" + mSimpleModuleBeanProvider.get();
        mTvInfo.setText(step1 + step2 + step3);
    }

    private void initView() {
        mTvInfo = (TextView) findViewById(R.id.tv_info);
    }
}
