package com.example.administrator.live.Adater;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.Bean.List_Topic;
import com.example.administrator.live.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */

public class TopicListAdater extends BaseAdapter {
    private final FragmentActivity activity;
    private List<List_Course.DataBean.CourseBean> courseBeanListr;
    private List<List_Topic.DataBean.TopicBean> topicList;

    public TopicListAdater(FragmentActivity activity) {
        this.activity = activity;
    }
    public void setTopicDataList(List<List_Topic.DataBean.TopicBean> topicList){
        this.topicList = topicList;
    }
    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyView myView;
        if(convertView==null) {
            convertView=View.inflate(activity, R.layout.listviewitem_1,null);
            myView = new MyView();
            myView.audioimg= (ImageView) convertView.findViewById(R.id.audioimg);
            myView.type= (TextView) convertView.findViewById(R.id.type);
            myView.title1= (TextView) convertView.findViewById(R.id.title1);
            myView.title2= (TextView) convertView.findViewById(R.id.title2);
            myView.free= (TextView) convertView.findViewById(R.id.free);
            convertView.setTag(myView);
        }else{
           myView=(MyView)convertView.getTag();
        }
        int num = topicList.get(position).getType();
        if(num==1) {
            myView.type.setText("/视频");
        }else {
            myView.type.setText("/音频");
        }
        myView.title1.setText(topicList.get(position).getTitle());
        myView.title2.setText(topicList.get(position).getTitle2());
        myView.free.setText(topicList.get(position).getLength()+"堂课");
       /* Uri uri = Uri.parse(topicList.get(position).getImage());
        myView.audioimg.setImageURI(uri);*/
        Glide.with(activity).load(topicList.get(position).getImage()).into(myView.audioimg);
        return convertView;
    }
    class MyView{
        ImageView audioimg;
        TextView type;
        TextView title1;
        TextView title2;
        TextView free;
    }
}
