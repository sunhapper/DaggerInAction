package me.sunhapper.dagger.daggerinaction.bean;

import android.app.Activity;

import javax.inject.Inject;

import dagger.sunhapper.me.baselib.bean.BaseBean;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SimpleActivityBean extends BaseBean {
    Activity mSimpleActivity;

    @Inject
    public SimpleActivityBean(Activity simpleActivity) {
        mSimpleActivity = simpleActivity;
    }
}
