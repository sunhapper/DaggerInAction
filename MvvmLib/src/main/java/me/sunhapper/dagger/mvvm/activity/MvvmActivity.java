package me.sunhapper.dagger.mvvm.activity;

import android.os.Bundle;

import java.util.List;

import dagger.sunhapper.me.baselib.commons.RxUtil;
import dagger.sunhapper.me.mvvmlib.R;
import io.reactivex.subscribers.DefaultSubscriber;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.mvvm.viewmodel.GankMeiziViewModel;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/29 .
 */
public class MvvmActivity extends BaseMvvmActivity<GankMeiziViewModel> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        mViewModel.getMeiziList(1)
                .compose(RxUtil.<List<Meizi>>applySchedulers())
                .subscribe(new DefaultSubscriber<List<Meizi>>() {
                    @Override
                    public void onNext(List<Meizi> meizis) {
                        Timber.i("onNext: %s", meizis.size());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Timber.e(t);
                    }

                    @Override
                    public void onComplete() {
                        Timber.i("onComplete");
                    }
                });
    }

    @Override
    protected GankMeiziViewModel createViewModel() {
        return getViewModel(GankMeiziViewModel.class);
    }
}
