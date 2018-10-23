package me.sunhapper.dagger.daggerinaction.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dagger.sunhapper.me.baselib.activity.BaseActivity;
import dagger.sunhapper.me.daggerinaction.R;
import me.sunhapper.dagger.mvvm.activity.MeiziTimerActivity;

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

    public void enterMvpActivity(View view) {

    }


    public void enterMeiziTimerActivity(View view) {
        Intent intent = new Intent(this, MeiziTimerActivity.class);
        startActivity(intent);
    }
}
