package dagger.sunhapper.me.baselib.network;

import android.arch.lifecycle.LiveData;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/10/6 .
 */
public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<R>> {
    private final Type responseType;
    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<R> adapt(final Call<R> call) {
        return new LiveData<R>() {
            AtomicBoolean started = new AtomicBoolean(false);
            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            Timber.d("success");
                            postValue(response.body());
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            Timber.d(throwable," failure");
                            postValue(null);
                        }
                    });
                }
            }
        };
    }
}
