package me.sunhapper.dagger.apilib.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import me.sunhapper.dagger.apilib.bean.Meizi;
import me.sunhapper.dagger.apilib.datasource.MeiziDao;


/**
 * Created by sunhapper on 2018/9/6 .
 */
@Database(entities = {Meizi.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MeiziDao meiziDao();

}
