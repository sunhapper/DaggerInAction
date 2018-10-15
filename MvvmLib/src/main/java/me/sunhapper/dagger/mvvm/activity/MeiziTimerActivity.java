package me.sunhapper.dagger.mvvm.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import dagger.sunhapper.me.baselib.commons.RxUtil;
import dagger.sunhapper.me.mvvmlib.R;
import io.reactivex.subscribers.DefaultSubscriber;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.mvvm.viewmodel.MeiziTimerViewModel;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/29 .
 */
public class MeiziTimerActivity extends BaseMvvmActivity<MeiziTimerViewModel> {
    private ImageView mIvForLifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meizi_timer);
        initView();
//        testRxLifecycle();
        testAutoDispose();
    }


    @Override
    protected MeiziTimerViewModel createViewModel() {
        return getViewModel(MeiziTimerViewModel.class);
    }

    private void initView() {
        mIvForLifecycle = (ImageView) findViewById(R.id.iv_for_lifecycle);
    }


    public void testRxLifecycle() {
        mViewModel.getOneMeizi()
                //RxLifecycle
                .compose(this.<Meizi>bindToLifecycle())
                //RxLifecycle-Android-Lifecycle
//                .compose(provider.<Meizi>bindToLifecycle())
                //RxLifecycle 指定具体的生命周期
//                .compose(this.<Meizi>bindUntilEvent(ActivityEvent.DESTROY))
                .compose(RxUtil.<Meizi>applySchedulers())
//                .as(AutoDispose.<Meizi>autoDisposable(AndroidLifecycleScopeProvider.from(this)))//AutoDispose
                .subscribe(new DefaultSubscriber<Meizi>() {
                    @Override
                    public void onNext(Meizi meizi) {
                        Glide.with(mIvForLifecycle).load(meizi.url).into(mIvForLifecycle);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Timber.e(t);
                        Toast.makeText(MeiziTimerActivity.this, "load_error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MeiziTimerActivity.this, "load_complete", Toast.LENGTH_SHORT).show();
                        Timber.i("onComplete");
                    }
                });
        mViewModel.getMeiziPn()
                .compose(this.<Integer>bindToLifecycle())
                .compose(RxUtil.<Integer>applySchedulers())
                .subscribe(new DefaultSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Toast.makeText(MeiziTimerActivity.this, "" + integer, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
                        Toast.makeText(MeiziTimerActivity.this, "load_error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MeiziTimerActivity.this, "load_complete", Toast.LENGTH_SHORT).show();
                        Timber.i("onComplete");
                    }
                });

        mViewModel.getMeiziPn()
                .compose(RxUtil.<Integer>applySchedulers())
                .as(AutoDispose.<Integer>autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new DefaultSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Toast.makeText(MeiziTimerActivity.this, "" + integer, Toast.LENGTH_SHORT).show();
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
