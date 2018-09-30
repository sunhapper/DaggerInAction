package me.sunhapper.dagger.apilib.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import me.sunhapper.dagger.apilib.database.DateConverter;


/**
 * Created by sunhapper on 2018/9/5 .
 */
@Entity
public class Meizi {


    /**
     * _id : 5b830bba9d2122031f86ee51
     * createdAt : 2018-08-27T04:21:14.703Z
     * desc : 2018-08-27
     * publishedAt : 2018-08-28T00:00:00.0Z
     * source : web
     * type : 福利
     * url : https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg
     * used : true
     * who : lijinshanmx
     */
    @PrimaryKey
    @NonNull
    public String _id;
    @TypeConverters(value = {DateConverter.class})
    public Date createdAt;
    public String desc;
    @TypeConverters(value = {DateConverter.class})
    public Date publishedAt;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;

}
