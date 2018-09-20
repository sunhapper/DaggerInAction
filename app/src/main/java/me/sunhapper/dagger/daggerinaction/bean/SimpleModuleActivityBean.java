package me.sunhapper.dagger.daggerinaction.bean;

import android.app.Activity;

import dagger.sunhapper.me.baselib.bean.BaseBean;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SimpleModuleActivityBean extends BaseBean {
    private Activity mActivity;

    public SimpleModuleActivityBean(Activity activity) {
        mActivity = activity;
    }
}
