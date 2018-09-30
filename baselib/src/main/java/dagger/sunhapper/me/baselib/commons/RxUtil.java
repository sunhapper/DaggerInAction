package dagger.sunhapper.me.baselib.commons;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sunhapper on 2018/9/6 .
 */
public class RxUtil {
    private RxUtil() {
    }

    public static <Upstream> FlowableTransformer<Upstream, Upstream> applySchedulers() {
        return new FlowableTransformer<Upstream, Upstream>() {
            @Override
            public Publisher apply(Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
