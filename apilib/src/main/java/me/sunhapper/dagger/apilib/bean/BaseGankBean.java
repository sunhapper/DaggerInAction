package me.sunhapper.dagger.apilib.bean;

/**
 * Created by sunhapper on 2018/9/5 .
 */
public class BaseGankBean<T> implements NetworkResult<T> {
    public boolean error;
    public T results;

    @Override
    public T get() {
        return results;
    }

    @Override
    public boolean isSuccess() {
        return !error;
    }

    @Override
    public String getErrorMessage() {
        return "unsuccessful_response";
    }
}
