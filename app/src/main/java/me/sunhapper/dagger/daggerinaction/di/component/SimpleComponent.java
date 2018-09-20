package me.sunhapper.dagger.daggerinaction.di.component;

import android.app.Activity;

import dagger.BindsInstance;
import dagger.Component;
import me.sunhapper.dagger.daggerinaction.activity.SimpleActivity;
import me.sunhapper.dagger.daggerinaction.di.module.SimpleModule;
import me.sunhapper.dagger.daggerinaction.di.scope.SimpleScope;

/**
 * Created by sunhapper on 2018/9/20 .
 */
@Component(modules = SimpleModule.class)
@SimpleScope
public interface SimpleComponent {
    void inject(SimpleActivity simpleActivity);

    @Component.Builder
    interface Builder {
        //创建Component的时候绑定实例
        @BindsInstance
        Builder simpleActivity(Activity simpleActivity);

        //使用了Builder就需要显式的指定带参数的module作为builder的参数
        Builder simpleModule(SimpleModule simpleModule);

        SimpleComponent build();

    }
}
