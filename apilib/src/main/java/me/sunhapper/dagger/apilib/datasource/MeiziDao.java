package me.sunhapper.dagger.apilib.datasource;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;
import me.sunhapper.dagger.apilib.bean.Meizi;

/**
 * Created by sunhapper on 2018/9/6 .
 */
@Dao
public interface MeiziDao {

    @Query("SELECT * from Meizi  ORDER BY createdAt desc limit 0,:pageSize")
    Single<List<Meizi>> getCacheMeizi(int pageSize);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrReplaceMeiziList(List<Meizi> meiziList);
}
