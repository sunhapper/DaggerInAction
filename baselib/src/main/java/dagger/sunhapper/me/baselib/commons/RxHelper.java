/*
 * Copyright (C) 2018 贵阳货车帮科技有限公司
 */

package dagger.sunhapper.me.baselib.commons;

import android.app.Activity;
import android.app.Dialog;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by sunhapper on 2018/8/30 .
 */

public class RxHelper {
    private Activity mActivity;
    private Dialog mProgressDialog;

    public RxHelper(Activity activity) {
        mActivity = activity;
    }

    public <Upstream> FlowableTransformer<Upstream, Upstream> showDialog(final String msg) {
        return new FlowableTransformer<Upstream, Upstream>() {
            @Override
            public Publisher<Upstream> apply(Flowable<Upstream> upstream) {
                return upstream
                        .doOnSubscribe(new Consumer<Subscription>() {
                            @Override
                            public void accept(Subscription subscription) throws Exception {
                                // TODO: 2018/9/6  showDialog

                            }
                        })
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {
                                // TODO: 2018/9/6 hideDialog
                            }
                        });
            }
        };
    }
}
