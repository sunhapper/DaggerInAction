package me.sunhapper.dagger.mvvm.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

import javax.inject.Inject;
import javax.inject.Named;

import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;
import me.sunhapper.dagger.mvvm.di.component.MvvmViewComponent;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/10/25 .
 */
public class InjectionView extends CoordinatorLayout {
    @Inject
    @Named(value = "view")
    String name;

    public InjectionView(Context context) {
        super(context);
        init(context);
    }


    public InjectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InjectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        MvvmViewComponent.Builder builder = ((MeiziTimerActivity) context).mViewBuilder;
        builder.build().inject(this);
        Timber.i(name);
    }
}
