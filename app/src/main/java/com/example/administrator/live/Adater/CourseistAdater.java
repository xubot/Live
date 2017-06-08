package com.example.administrator.live.Adater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */

public class CourseistAdater extends BaseAdapter{

    private List<List_Course.DataBean.CourseBean> courseDataList;
    private Context context;

    public CourseistAdater(Context context) {
        this.context = context;
    }
    public void setCourseDataList(List<List_Course.DataBean.CourseBean> courseDataList) {
        this.courseDataList = courseDataList;
    }

    @Override
    public int getCount() {
        return courseDataList.size();
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
            convertView=View.inflate(context, R.layout.listviewitem,null);
            myView=new MyView();
            myView.audioimg= (ImageView) convertView.findViewById(R.id.audioimg);
            myView.type= (TextView) convertView.findViewById(R.id.type);
            myView.title1= (TextView) convertView.findViewById(R.id.title1);
            myView.title2= (TextView) convertView.findViewById(R.id.title2);
            myView.speaker= (TextView) convertView.findViewById(R.id.speaker);
            myView.length= (TextView) convertView.findViewById(R.id.length);
            myView.size= (TextView) convertView.findViewById(R.id.size);
            myView.free= (TextView) convertView.findViewById(R.id.free);
            convertView.setTag(myView);
        }else{
            myView=(MyView)convertView.getTag();
        }
        int num = courseDataList.get(position).getType();
        if(num==1) {
            myView.type.setText("视频");
        }else {
            myView.type.setText("音频");
        }
        myView.free.setText("￥："+courseDataList.get(position).getPrice()+"");
        myView.size.setText(courseDataList.get(position).getVolume()+"");
        myView.title1.setText(courseDataList.get(position).getTitle());
        myView.title2.setText(courseDataList.get(position).getTitle2());
        myView.speaker.setText(courseDataList.get(position).getSpeaker());
        myView.length.setText(courseDataList.get(position).getLength()+"秒");
       /* Uri uri = Uri.parse(courseDataList.get(position).getImage()+"");
        myView.audioimg.setImageURI(uri);*/
        Glide.with(context).load(courseDataList.get(position).getImage()).into(myView.audioimg);
        return convertView;
    }
    class MyView{
        ImageView audioimg;
        TextView type;
        TextView title1;
        TextView title2;
        TextView speaker;
        TextView length;
        TextView size;
        TextView free;
    }
}
