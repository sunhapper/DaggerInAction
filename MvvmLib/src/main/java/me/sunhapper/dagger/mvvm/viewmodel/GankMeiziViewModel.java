package me.sunhapper.dagger.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import me.sunhapper.dagger.apilib.bean.BaseGankBean;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.mvvm.repository.GankRepository;

/**
 * Created by sunhapper on 2018/9/6 .
 */
public class GankMeiziViewModel extends BaseViewModel {
    @Inject
    GankRepository mGankRepository;

    @Inject
    public GankMeiziViewModel(@NonNull Application application) {
        super(application);
    }

    public Flowable<List<Meizi>> getMeiziList(int pageNum) {
        return mGankRepository.getMeiziList(pageNum);
    }

    public LiveData<BaseGankBean<List<Meizi>>> getMeiziListByLiveData(int pageNum) {
        return mGankRepository.getMeiziListByLiveData(pageNum);
    }
}
