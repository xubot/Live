package com.example.administrator.live.Activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.live.Bean.Detail_Course;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.ShowView;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ShowActivity extends BaseActivity implements ShowView {
    //得到数据库的工具类对象
    SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance();
    private String url;
    private String object_id;
    private String image;
    private JCVideoPlayer jCVideoPlayer;
    private int  flag;
    private int price;

    @Override
    public void initView() {
        setContentView(R.layout.activity_show);
        setToolBar("",R.mipmap.back_pressed,R.color.bai,R.menu.zhihu_toolbar_menunull);
        //得到数据的URL
        url = (String) instance.getData(ShowActivity.this, "URL", "");
        Log.d("zzz","load:"+ url);
        Intent intent = getIntent();
        object_id = intent.getStringExtra("object_id");
        image = intent.getStringExtra("image");
        flag = intent.getIntExtra("flag", 0);
        price = intent.getIntExtra("price", 0);
    }

    @Override
    protected void init() {
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        Button pay= (Button) findViewById(R.id.pay);
        if(flag==1){
            pay.setVisibility(View.GONE);
        }else{
            pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("tgb", price+"");
                    Intent intent = new Intent(ShowActivity.this, PayActivity.class);
                    intent.putExtra("endprice",price);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void load() {
        PresenterLayer presenterLayer = new PresenterLayer();
        presenterLayer.setShowView(this);
        presenterLayer.getDetail_Course(url,object_id);
    }

    @Override
    public void setToolBar(String name, int img, int color, int menuitem) {
        super.setToolBar(name, img, color, menuitem);
    }

    @Override
    public void getdetail_course(Detail_Course detail_course) {
        String title = detail_course.getData().getTitle();
        String course_video = detail_course.getData().getCourse_video();
        Log.d("zzz", title);
        jCVideoPlayer.setUp(course_video,title);
        jCVideoPlayer.ivThumb.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(this).load(image).into(jCVideoPlayer.ivThumb);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.releaseAllVideos();
    }
}
