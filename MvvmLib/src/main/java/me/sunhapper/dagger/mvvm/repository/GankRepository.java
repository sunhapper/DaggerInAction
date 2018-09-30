package me.sunhapper.dagger.mvvm.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import me.sunhapper.dagger.apilib.api.GankApiService;
import me.sunhapper.dagger.apilib.bean.BaseGankBean;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.apilib.common.ApiRxUtil;
import me.sunhapper.dagger.apilib.datasource.GankDataSource;

/**
 * Created by sunhapper on 2018/9/5 .
 */
public class GankRepository {
    public static final int DEFAULT_PAGE_SIZE = 30;
    public static final int INIT_PAGE_NUM = 1;
    @Inject
    GankApiService mGankApiService;
    @Inject
    GankDataSource mGankDataSource;

    @Inject
    public GankRepository() {
    }

    public Flowable<List<Meizi>> getMeiziList(int pageNum) {
        Flowable<List<Meizi>> flowable;
        final Flowable<BaseGankBean<List<Meizi>>> networkFlowable = mGankApiService.getMeiziImgList(DEFAULT_PAGE_SIZE,
                pageNum);
        if (pageNum == INIT_PAGE_NUM) {

            Single<List<Meizi>> cacheSingle = mGankDataSource.getCacheMeizi(DEFAULT_PAGE_SIZE);
            flowable = Flowable.concatArrayEager(cacheSingle.toFlowable(),
                    networkFlowable.compose(ApiRxUtil.<List<Meizi>>getGankResultContent()).doOnNext(
                            new Consumer<List<Meizi>>() {
                                @Override
                                public void accept(List<Meizi> meizis) throws Exception {
                                    mGankDataSource.cacheMeizi(meizis);
                                }
                            }));

        } else {
            flowable = networkFlowable.compose(ApiRxUtil.<List<Meizi>>getGankResultContent());
        }
        return flowable;
    }
}
