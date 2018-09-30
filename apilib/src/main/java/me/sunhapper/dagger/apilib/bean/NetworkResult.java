package me.sunhapper.dagger.apilib.bean;

/**
 * Created by sunhapper on 2018/9/12 .
 */
public interface NetworkResult<T> {
    T get();

    boolean isSuccess();

    String getErrorMessage();

}
