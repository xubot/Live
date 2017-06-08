package com.example.administrator.live.Adater;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.Bean.List_Try;
import com.example.administrator.live.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */

public class TryListAdater extends BaseAdapter {
    private final FragmentActivity activity;
    private List<List_Try.DataBean.TryBean> aTry;
    private List<List_Course.DataBean.CourseBean> courseBeanListr;

    public TryListAdater(FragmentActivity activity) {
        this.activity = activity;
    }
    public void setTryDataList(List<List_Try.DataBean.TryBean> aTry){
        this.aTry = aTry;
    }
    @Override
    public int getCount() {
        return aTry.size();
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
            convertView=View.inflate(activity, R.layout.listviewitem,null);
            myView = new MyView();
            myView.audioimg= (ImageView) convertView.findViewById(R.id.audioimg);
            myView.type= (TextView) convertView.findViewById(R.id.type);
            myView.title1= (TextView) convertView.findViewById(R.id.title1);
            myView.title2= (TextView) convertView.findViewById(R.id.title2);
            myView.speaker= (TextView) convertView.findViewById(R.id.speaker);
            myView.length= (TextView) convertView.findViewById(R.id.length);
            convertView.setTag(myView);
        }else{
           myView=(MyView)convertView.getTag();
        }
        int num = aTry.get(position).getType();
        if(num==1) {
            myView.type.setText("视频");
        }else {
            myView.type.setText("音频");
        }
        myView.title1.setText(aTry.get(position).getTitle());
        myView.title2.setText(aTry.get(position).getTitle2());
        myView.speaker.setText(aTry.get(position).getSpeaker());
        myView.length.setText(aTry.get(position).getLength()+"秒");
        /*Uri uri = Uri.parse(aTry.get(position).getImage());
        myView.audioimg.setImageURI(uri);*/
        Glide.with(activity).load(aTry.get(position).getImage()).into(myView.audioimg);
        return convertView;
    }
    class MyView{
        ImageView audioimg;
        TextView type;
        TextView title1;
        TextView title2;
        TextView speaker;
        TextView length;
    }
}
