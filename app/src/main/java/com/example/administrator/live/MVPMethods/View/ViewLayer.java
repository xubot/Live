package com.example.administrator.live.MVPMethods.View;

import android.content.Context;

import com.example.administrator.live.Bean.First_hand;
import com.example.administrator.live.Bean.Host;

/**
 * Created by Administrator on 2017/5/25.
 */

public interface ViewLayer {
    void success();
    void getFirst_hand(First_hand first_hand);
    void getHost(Host host);
    Context getActivityContext();
}
