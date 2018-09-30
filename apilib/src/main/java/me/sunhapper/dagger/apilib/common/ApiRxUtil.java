package me.sunhapper.dagger.apilib.common;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Function;
import me.sunhapper.dagger.apilib.bean.BaseGankBean;
import me.sunhapper.dagger.apilib.bean.NetworkResult;

/**
 * Created by sunhapper on 2018/9/6 .
 */
public class ApiRxUtil {
    private ApiRxUtil() {
    }

    public static <T> FlowableTransformer<BaseGankBean<T>, T> getGankResultContent() {
        return new FlowableTransformer<BaseGankBean<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<BaseGankBean<T>> upstream) {
                return upstream.map(new Function<BaseGankBean<T>, T>() {
                    @Override
                    public T apply(BaseGankBean<T> listBaseGankBean) throws Exception {
                        return listBaseGankBean.results;
                    }
                });
            }
        };
    }


    public static <T> Function<NetworkResult<T>, Publisher<T>> getRxNetworkErrorFun() {
        return new Function<NetworkResult<T>, Publisher<T>>() {
            @Override
            public Publisher<T> apply(NetworkResult<T> tNetworkResult) throws Exception {
                if (tNetworkResult.isSuccess()) {
                    return Flowable.just(tNetworkResult.get());
                } else {
                    return Flowable.error(new Throwable(tNetworkResult.getErrorMessage()));
                }
            }
        };
    }
}
