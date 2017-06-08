package com.example.administrator.live.MVPMethods.View;

import android.content.Context;

import com.example.administrator.live.Bean.User_Pwd_Login;

/**
 * Created by Administrator on 2017/6/7.
 */

public interface LogView {
    void getuser_pwd_login(User_Pwd_Login user_pwd_login);
    Context getActivityContext();
}
