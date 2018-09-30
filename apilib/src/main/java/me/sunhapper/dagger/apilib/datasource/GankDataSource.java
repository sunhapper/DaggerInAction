package me.sunhapper.dagger.apilib.datasource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import me.sunhapper.dagger.apilib.bean.Meizi;

/**
 * Created by sunhapper on 2018/9/5 .
 */
public class GankDataSource {
    @Inject
    MeiziDao mMeiziDao;

    @Inject
    public GankDataSource() {
    }

    public void cacheMeizi(List<Meizi> meiziList) {
        mMeiziDao.insertOrReplaceMeiziList(meiziList);
    }

    public Single<List<Meizi>> getCacheMeizi(int size) {
        return mMeiziDao.getCacheMeizi(size);

    }


}
