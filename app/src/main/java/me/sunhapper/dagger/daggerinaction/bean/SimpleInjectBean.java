package me.sunhapper.dagger.daggerinaction.bean;

import javax.inject.Inject;

import dagger.sunhapper.me.baselib.bean.BaseBean;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SimpleInjectBean extends BaseBean {
    public SimpleModuleBean mSimpleModuleBean;
    public SimpleInjectExtraBean mSimpleInjectExtraBean;

    @Inject
    public SimpleInjectBean(SimpleModuleBean simpleModuleBean,
            SimpleInjectExtraBean simpleInjectExtraBean) {
        mSimpleModuleBean = simpleModuleBean;
        mSimpleInjectExtraBean = simpleInjectExtraBean;
    }
}
