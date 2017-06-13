package com.example.administrator.live.Utils;

import android.content.Context;

import com.example.administrator.live.Utils.First_handUtils.DeviceUtil;
import com.example.administrator.live.Utils.First_handUtils.TimeUtil;

/**
 * Created by Administrator on 2017/5/27.
 */

public class STRINGBUFFER {
    //First_hand的拼接参数
    public static StringBuffer setFirst_hand(Context context) {
        StringBuffer sb = new StringBuffer();
        sb.append(URLCLASS.PUBLIC_KEY)
                .append(URLCLASS.TYPE)
                .append(DeviceUtil.getLocaldeviceId(context))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai());
        return sb;
    }
    //Host的拼接参数
    public static StringBuffer setHost(String private_key, String app_id, Context context) {
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(context))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai());
        return sb;
    }
    //banner的拼接参数
    public static StringBuffer setBanner(String private_key, String app_id, Context fContext) {
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(fContext))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai());
        return sb;
    }
    //list_Try的拼接参数
    public static StringBuffer setList_Try(String private_key, String app_id, Context fContext){
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(fContext))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai())
                .append(4)
                .append(0);
        return sb;
    }
    //User_Reg的拼接参数
    public static StringBuffer setUser_Reg(String private_key, String app_id, Context logincontext,String phone){
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(logincontext))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai())
                .append(phone);
        return sb;
    }
    //User_Reg的拼接参数
    public static StringBuffer setUser_Check_Rand(String private_key, String app_id, Context logincontext,String session,String code,String pwd){
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(logincontext))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai())
                .append(session)
                .append(code)
                .append(pwd);
        return sb;
    }
    //User_Pwd_Login的拼接参数
    public static StringBuffer setUser_Pwd_Login(String private_key, String app_id, Context logcontext,String user,String pwd) {
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(logcontext))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai())
                .append(user)
                .append(pwd);
        return sb;
    }
    //User_Pwd_Login的拼接参数
    public static StringBuffer setDetail_Course(String private_key, String app_id, Context showcontext,String object_id){
        StringBuffer sb = new StringBuffer();
        sb.append(private_key)
                .append(app_id)
                .append(DeviceUtil.getLocaldeviceId(showcontext))
                .append(URLCLASS.VER_CODE)
                .append(TimeUtil.timeFormatYuzhilai())
                .append(object_id);
        return sb;
    }
}
