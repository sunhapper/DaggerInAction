package me.sunhapper.dagger.mvvm.activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.AndroidSupportInjection;
import dagger.sunhapper.me.baselib.commons.RxUtil;
import dagger.sunhapper.me.mvvmlib.R;
import io.reactivex.subscribers.DefaultSubscriber;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.mvvm.di.component.MvvmViewComponent;
import me.sunhapper.dagger.mvvm.factory.ViewModelFactory;
import me.sunhapper.dagger.mvvm.viewmodel.MeiziTimerViewModel;
import timber.log.Timber;

/**
 * A placeholder fragment containing a simple view.
 */
public class MeiziTimerFragment extends Fragment {
    private ImageView mIvForLifecycle;
    @Inject
    @Named("activity")
    String activityName;
    @Inject
    @Named("fragment")
    String fragmentName;
    @Inject
    ViewModelFactory mViewModelFactory;
    @Inject
    public MvvmViewComponent.Builder mViewBuilder;
    protected MeiziTimerViewModel mViewModel;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        Timber.i("%s  %s", activityName, fragmentName);
        super.onAttach(context);
    }

    public MeiziTimerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meizi_timer, container, false);
        mIvForLifecycle = view.findViewById(R.id.iv_for_lifecycle);
        mViewModel = createViewModel();
        testAutoDispose();
        return view;
    }


    protected MeiziTimerViewModel createViewModel() {
        return getViewModel(MeiziTimerViewModel.class);
    }


    public <T extends ViewModel> T getViewModel(@NonNull Class<T> modelClass) {
        return getViewModel(modelClass, mViewModelFactory);
    }

    private <T extends ViewModel> T getViewModel(@NonNull Class<T> modelClass,
            @Nullable ViewModelProvider.Factory factory) {
        return ViewModelProviders.of(this, factory).get(modelClass);
    }


    public void testAutoDispose() {
        mViewModel.getOneMeizi()
                .compose(RxUtil.<Meizi>applySchedulers())
                .as(AutoDispose.<Meizi>autoDisposable(AndroidLifecycleScopeProvider.from(this)))//AutoDispose
                .subscribe(new DefaultSubscriber<Meizi>() {
                    @Override
                    public void onNext(Meizi meizi) {
                        Glide.with(mIvForLifecycle).load(meizi.url).into(mIvForLifecycle);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Timber.e(t);
                        Toast.makeText(getActivity(), "load_error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(getActivity(), "load_complete", Toast.LENGTH_SHORT).show();
                        Timber.i("onComplete");
                    }
                });

        mViewModel.getMeiziPn()
                .compose(RxUtil.<Integer>applySchedulers())
                .as(AutoDispose.<Integer>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new DefaultSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Toast.makeText(getActivity(), "" + integer, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
