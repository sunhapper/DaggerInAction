package me.sunhapper.dagger.daggerinaction.bean;

import javax.inject.Inject;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class SimpleInjectBean {

    public SimpleInjectExtraBean mSimpleInjectExtraBean;

    @Inject
    public SimpleInjectBean(SimpleInjectExtraBean extraBean) {
        mSimpleInjectExtraBean = extraBean;
    }

}
