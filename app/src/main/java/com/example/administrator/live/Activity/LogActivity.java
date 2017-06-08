package com.example.administrator.live.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.live.Bean.User_Pwd_Login;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.LogView;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;

public class LogActivity extends AppCompatActivity implements LogView{

    private EditText log_edit_usre;
    private EditText log_edit_pwd;
    private SharedPreferencesUtils instance;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
        toolbar.setNavigationIcon(R.mipmap.leftarrow);
        init();
    }

    private void init() {
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
                locd();
            }
        });
        phonelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogActivity.this,LoginActivity.class));
            }
        });
    }
    private void locd() {
        //得到数据库的工具类对象
        instance = SharedPreferencesUtils.getInstance();
        //得到数据的URL
        url = (String) instance.getData(LogActivity.this, "URL", "");
        Log.d("qqq","load:"+ url);
        String usre = log_edit_usre.getText().toString().trim();
        String pwd = log_edit_pwd.getText().toString();
        Log.d("qqq", usre);
        PresenterLayer presenterLayer = new PresenterLayer();
        presenterLayer.setLogView(this);
        Log.d("qqq", usre);
        presenterLayer.getUser_Pwd_Login(url,usre,pwd);
    }

    @Override
    public void getuser_pwd_login(User_Pwd_Login user_pwd_login) {
        String session = user_pwd_login.getData().getSession();
        Log.d("qqq",session);
        String message = user_pwd_login.getData().getMessage();
        Log.d("qqq",message);
        int ret = user_pwd_login.getRet();
        switch (ret){
            case -5:
                Toast.makeText(this, "手机未注册", Toast.LENGTH_SHORT).show();
                break;
            case -7:
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                break;
            case -9:
                Toast.makeText(this, "连续密码输错5次，账号锁定15分钟", Toast.LENGTH_SHORT).show();
                break;
            case -10:
                Toast.makeText(this, "手机号格式错误", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public Context getActivityContext() {
        return this;
    }
}
