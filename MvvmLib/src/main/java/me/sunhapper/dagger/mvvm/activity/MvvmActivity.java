package me.sunhapper.dagger.mvvm.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dagger.sunhapper.me.baselib.commons.RxUtil;
import dagger.sunhapper.me.mvvmlib.R;
import io.reactivex.subscribers.DefaultSubscriber;
import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.mvvm.adapter.ImageAdapter;
import me.sunhapper.dagger.mvvm.viewmodel.GankMeiziViewModel;
import timber.log.Timber;

/**
 * Created by sunhapper on 2018/9/29 .
 */
public class MvvmActivity extends BaseMvvmActivity<GankMeiziViewModel> {
    private RecyclerView mRvMeizi;
    private ImageAdapter mImageAdapter;
    private List<Meizi> mMeizis=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        initView();
        mImageAdapter=new ImageAdapter(mMeizis);
        mRvMeizi.setAdapter(mImageAdapter);
        mRvMeizi.setLayoutManager(new LinearLayoutManager(this));
        mViewModel.getMeiziList(1)
                .compose(RxUtil.<List<Meizi>>applySchedulers())
                .subscribe(new DefaultSubscriber<List<Meizi>>() {
                    @Override
                    public void onNext(List<Meizi> meizis) {
                        Toast.makeText(MvvmActivity.this, "load_success", Toast.LENGTH_SHORT).show();
                        Timber.i("onNext: %s", meizis.size());
                        refreshData(meizis);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Timber.e(t);
                        Toast.makeText(MvvmActivity.this, "load_error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Timber.i("onComplete");
                    }
                });

    }

    private void refreshData(List<Meizi> meizis) {
        mMeizis.clear();
        mMeizis.addAll(meizis);
        mImageAdapter.notifyDataSetChanged();
    }

    @Override
    protected GankMeiziViewModel createViewModel() {
        return getViewModel(GankMeiziViewModel.class);
    }

    private void initView() {
        mRvMeizi = (RecyclerView) findViewById(R.id.rv_meizi);
    }
}
