package me.sunhapper.dagger.apilib.di.scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

/**
 * Created by sunhapper on 2018/8/16 .
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ApiScope {
}
