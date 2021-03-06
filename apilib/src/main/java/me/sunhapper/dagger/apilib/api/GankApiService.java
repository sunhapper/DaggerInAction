package me.sunhapper.dagger.apilib.api;

import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Flowable;
import me.sunhapper.dagger.apilib.bean.BaseGankBean;
import me.sunhapper.dagger.apilib.bean.Meizi;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sunhapper on 2018/9/4 .
 */
public interface GankApiService {
    @GET("api/data/福利/{pageSize}/{pageNum}")
    Flowable<BaseGankBean<List<Meizi>>> getMeiziImgListByRxJava(@Path("pageSize") int pageSize, @Path("pageNum") int pageNum);

    @GET("api/data/福利/{pageSize}/{pageNum}")
    LiveData<BaseGankBean<List<Meizi>>> getMeiziImgListByLiveData(@Path("pageSize") int pageSize, @Path("pageNum") int pageNum);

}
