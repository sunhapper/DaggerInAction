package dagger.sunhapper.me.baselib.bean;

/**
 * Created by sunhapper on 2018/9/20 .
 */
public class BaseBean {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }
}
