package dagger.sunhapper.me.baselib.activity;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.sunhapper.me.baselib.R;

/**
 * Created by sunhapper on 2018/9/19 .
 */
public class BaseImplActivity extends BaseActivity {
    @Inject
    Integer versionCode;
    private TextView mTvBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_base_impl);
        initView();
        mTvBase.setText(String.valueOf(versionCode));
    }

    private void initView() {
        mTvBase = (TextView) findViewById(R.id.tv_base);
    }
}
