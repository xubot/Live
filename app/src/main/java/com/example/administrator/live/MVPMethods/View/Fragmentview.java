package com.example.administrator.live.MVPMethods.View;

import android.content.Context;

import com.example.administrator.live.Bean.Banners;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.Bean.List_Topic;
import com.example.administrator.live.Bean.List_Try;

/**
 * Created by Administrator on 2017/5/25.
 */

public interface Fragmentview {
    Context getActivityContext();
    void setBanner(Banners banner);
    void setTryListview(List_Try list_try);
    void setCourseListview(List_Course List_course);
    void setCourseListview(List_Topic List_topic);
}
