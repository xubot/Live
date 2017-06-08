package com.example.administrator.live.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/5/26.
 */

public class SharedPreferencesUtils {
    //存储在手机中的文件名
    private static  String FILE_NAME="KEY";
    private  static SharedPreferencesUtils  sharedUtils;

    public static SharedPreferencesUtils getInstance(){
        if(sharedUtils==null){
            sharedUtils=new SharedPreferencesUtils();
        }
        return sharedUtils;
    }
    //将构造方法设计成私有的
    private SharedPreferencesUtils(){}
    /**
     * 保存数据
     * @param mContext 数据上下文
     * @param key 键值
     * @param object 值
     */
    public void saveData(Context mContext, String key, Object object){
        //得到对象
        SharedPreferences sp=mContext.getSharedPreferences(FILE_NAME, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        //instanceof运算符：指出对象是否是特定类的或它子类的一个实例
        //Integer是int的一个封装类
        if(object instanceof String){
            editor.putString(key, (String)object);
        }else if(object instanceof Long){
            editor.putLong(key, (Long)object);
        }else if(object instanceof Boolean){
            editor.putBoolean(key, (Boolean)object);
        }else if(object instanceof Integer){
            editor.putInt(key, (Integer)object);
        }else if(object instanceof Float){
            editor.putFloat(key, (Float)object);
        }else{
        }
        editor.commit();
    }

    /**
     * 根据指定的键 得到值
     * @param mContext 数据上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 值
     */

    public Object getData(Context mContext,String key,Object defaultValue){
        SharedPreferences s=mContext.getSharedPreferences(FILE_NAME, mContext.MODE_PRIVATE);
        if(defaultValue instanceof String){
            return s.getString(key, (String)defaultValue);
        }else if(defaultValue instanceof Long){
            return s.getLong(key, (Long)defaultValue);
        }else if(defaultValue instanceof Boolean){
            return s.getBoolean(key, (Boolean)defaultValue);
        }else if(defaultValue instanceof Integer){
            return s.getInt(key, (Integer)defaultValue);
        }else if(defaultValue instanceof Float){
            return s.getFloat(key, (Float)defaultValue);
        }
        return null;
    }

    /**
     * 移除某个键
     * @param mContext
     * @param key
     */
    public void remove(Context mContext,String key){
        SharedPreferences gs=mContext.getSharedPreferences(FILE_NAME, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor=gs.edit();
        editor.remove(key);
        editor.commit();

    }

    /**
     * 清除所有数据
     * @param mContext
     * @param key
     */
    public void clear(Context mContext){
        SharedPreferences s=mContext.getSharedPreferences(FILE_NAME, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor=s.edit();
        editor.clear();
        editor.commit();

    }

    /**
     * 查询某个key是否已经存在
     * @param mContext
     * @param key
     * @return
     */
    public boolean isExist(Context mContext,String key){
        SharedPreferences s=mContext.getSharedPreferences(FILE_NAME, mContext.MODE_PRIVATE);
        return s.contains(key);
    }
}
