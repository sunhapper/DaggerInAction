package me.sunhapper.dagger.daggerinaction.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dagger.sunhapper.me.baselib.activity.BaseActivity;
import dagger.sunhapper.me.baselib.activity.BaseImplActivity;
import dagger.sunhapper.me.daggerinaction.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterSimpleActivity(View view) {
        Intent intent = new Intent(this, SimpleActivity.class);
        startActivity(intent);
    }

    public void enterDaggerAndroidActivity(View view) {
        Intent intent = new Intent(this, DaggerAndroidActivity.class);
        startActivity(intent);

    }

    public void enterMvpActivity(View view) {
        Intent intent = new Intent(this, BaseImplActivity.class);
        startActivity(intent);

    }

    public void enterMvvmActivity(View view) {
    }

    public void enterSubComponent1(View view) {
        Intent intent = new Intent(this, SubComponentActivity1.class);
        startActivity(intent);
    }

    public void enterSubComponent2(View view) {
        Intent intent = new Intent(this, SubComponentActivity2.class);
        startActivity(intent);
    }

    public void enterSubComponent3(View view) {
        Intent intent = new Intent(this, SubComponentActivity3.class);
        startActivity(intent);
    }
}
