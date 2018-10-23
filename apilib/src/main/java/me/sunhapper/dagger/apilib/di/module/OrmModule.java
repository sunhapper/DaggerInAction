package me.sunhapper.dagger.apilib.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import dagger.Module;
import dagger.Provides;
import me.sunhapper.dagger.apilib.database.AppDatabase;
import me.sunhapper.dagger.apilib.datasource.MeiziDao;
import me.sunhapper.dagger.apilib.di.scope.ApiScope;


/**
 * Created by sunhapper on 2018/9/5 .
 */
@Module
public class OrmModule {
    public static final String DB_NAME = "dagger_in_action";

    @Provides
    @ApiScope
    public AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, DB_NAME).build();
    }

    @Provides
    public MeiziDao provideMeiziDao(AppDatabase appDatabase) {
        return appDatabase.meiziDao();
    }

}
