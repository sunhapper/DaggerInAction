package me.sunhapper.dagger.mvvm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import dagger.sunhapper.me.mvvmlib.R;
import me.sunhapper.dagger.apilib.bean.Meizi;

/**
 * Created by sunhapper on 2018/10/6 .
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder>{
    List<Meizi> mMeizis;

    public ImageAdapter(List<Meizi> meizis) {
        mMeizis = meizis;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image,viewGroup,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder viewHolder, int i) {
        Meizi meizi=mMeizis.get(i);
        Glide.with(viewHolder.mImageView).load(meizi.url).into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mMeizis.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.iv_content);
        }
    }
}
