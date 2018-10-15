package me.sunhapper.dagger.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import me.sunhapper.dagger.apilib.bean.BaseGankBean;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.mvvm.repository.GankRepository;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/6 .
 */
public class MeiziTimerViewModel extends BaseViewModel {

    @Inject
    GankRepository mGankRepository;
    private Flowable<Meizi> meiziTimerFlowable;
    private Flowable<Integer> meiziPnFlowable;

    @Inject
    public MeiziTimerViewModel(@NonNull Application application) {
        super(application);
    }


    public Flowable<Meizi> getOneMeizi() {
        initMeiziTimerFlowable();
        return meiziTimerFlowable;
    }

    public Flowable<Integer> getMeiziPn() {
        initMeiziTimerFlowable();
        return meiziPnFlowable;
    }

    private void initMeiziTimerFlowable() {
        if (meiziPnFlowable == null) {
            meiziPnFlowable = Flowable.interval(0, 8, TimeUnit.SECONDS)
                    .map(new Function<Long, Integer>() {
                        @Override
                        public Integer apply(Long aLong) throws Exception {
                            int count = (int) (1 + aLong);
                            Timber.i("%d", count);
                            return count;
                        }
                    })
                    .publish()
                    .autoConnect();
            meiziTimerFlowable = meiziPnFlowable.flatMap(new Function<Integer, Publisher<List<Meizi>>>() {
                @Override
                public Publisher<List<Meizi>> apply(Integer i) throws Exception {
                    return mGankRepository.getMeiziList(1, i);
                }
            })
                    .filter(new Predicate<List<Meizi>>() {
                        @Override
                        public boolean test(List<Meizi> meizis) throws Exception {
                            return meizis.size() > 0;
                        }
                    })
                    .map(new Function<List<Meizi>, Meizi>() {
                        @Override
                        public Meizi apply(List<Meizi> meizis) throws Exception {
                            return meizis.get(0);
                        }
                    });

        }
    }

    public LiveData<BaseGankBean<List<Meizi>>> getMeiziListByLiveData(int pageNum) {
        return mGankRepository.getMeiziListByLiveData(pageNum);
    }
}
