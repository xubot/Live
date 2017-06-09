package com.example.administrator.live.Activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.live.Bean.User_Pwd_Login;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.LogView;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;

public class LogActivity extends BaseActivity implements LogView{
    private EditText log_edit_usre;
    private EditText log_edit_pwd;
    //得到数据库的工具类对象
    private SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance();
    private String url;
    private PresenterLayer presenterLayer;

    @Override
    public void initView() {
        setContentView(R.layout.activity_log);
        setToolBar("登录页面",R.mipmap.leftarrow,R.color.one,R.menu.zhihu_toolbar_menunull);
        //得到数据的URL
        url = (String) instance.getData(LogActivity.this, "URL", "");
        Log.d("qqq","load:"+ url);
    }

    @Override
    protected void init() {
        log_edit_usre = (EditText) findViewById(R.id.log_edit_usre);
        log_edit_pwd = (EditText) findViewById(R.id.log_edit_pwd);
        ImageView log= (ImageView) findViewById(R.id.log);
        ImageView phonelog= (ImageView) findViewById(R.id.phonelog);
        TextView forget= (TextView) findViewById(R.id.forget);
        LinearLayout weixin_ll= (LinearLayout) findViewById(R.id.weixin_ll);
        LinearLayout qq_ll= (LinearLayout) findViewById(R.id.qq_ll);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usre = log_edit_usre.getText().toString().trim();
                String pwd = log_edit_pwd.getText().toString();
                Log.d("qqq", "usre:"+usre+"   "+"pwd:"+pwd);
                presenterLayer.getUser_Pwd_Login(url,usre,pwd);
            }
        });
        phonelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogActivity.this,LoginActivity.class));
            }
        });
    }

    @Override
    protected void load() {
        presenterLayer = new PresenterLayer();
        presenterLayer.setLogView(this);
    }
    @Override
    public void setToolBar(String name, int img, int color,int menuitem) {
        super.setToolBar(name, img, color,menuitem);
    }

    @Override
    public void getuser_pwd_login(User_Pwd_Login user_pwd_login) {
        String session = user_pwd_login.getData().getSession();
        Log.d("qqq",session);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }
}
