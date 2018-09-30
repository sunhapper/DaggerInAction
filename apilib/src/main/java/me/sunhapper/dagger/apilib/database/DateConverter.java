package me.sunhapper.dagger.apilib.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by sunhapper on 2018/9/6 .
 */
public class DateConverter {
    @TypeConverter
    public static Date revertDate(long value) {
        return new Date(value);
    }

    @TypeConverter
    public static long converterDate(Date value) {
        return value.getTime();
    }


}
