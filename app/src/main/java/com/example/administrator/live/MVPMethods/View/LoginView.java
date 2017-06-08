package com.example.administrator.live.MVPMethods.View;

import android.content.Context;

import com.example.administrator.live.Bean.User_Check_Rand;
import com.example.administrator.live.Bean.User_Reg;

/**
 * Created by Administrator on 2017/6/6.
 */

public interface LoginView {
    void getUserData(User_Reg user_reg);
    void getUser_CheckData(User_Check_Rand user_check_rand);
    Context getActivityContext();
}
