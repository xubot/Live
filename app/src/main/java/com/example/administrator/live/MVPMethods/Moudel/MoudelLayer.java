package com.example.administrator.live.MVPMethods.Moudel;

import android.util.Log;

import com.example.administrator.live.Utils.SetCreate;

import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/5/25.
 */

public class MoudelLayer {
    public Retrofit getFirst_hand_HostData() {
        Log.d("zzz", "getFirst_hand_HostData");
        return SetCreate.setCreate();
    }
    public Retrofit getBannerData(String url){
        Log.d("zzz", "getBannerData:" + url);
        return SetCreate.setBanner(url);
    }
}
