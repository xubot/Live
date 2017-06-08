package com.example.administrator.live.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.live.Bean.User_Check_Rand;
import com.example.administrator.live.Bean.User_Reg;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.LoginView;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;


public class LoginActivity extends AppCompatActivity implements LoginView{

    private SharedPreferencesUtils instance;
    private String url;
    private String usre;
    private String code;
    private String pwd;
    private EditText phone;
    private PresenterLayer presenterLayer;
    private EditText login_edit_code;
    private EditText login_edit_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
        toolbar.setNavigationIcon(R.mipmap.leftarrow);
        init();
    }

    private void init() {
        phone = (EditText) findViewById(R.id.login_edit_usre);
        login_edit_code = (EditText) findViewById(R.id.login_edit_code);
        login_edit_pwd = (EditText) findViewById(R.id.login_edit_pwd);
        TextView getcode= (TextView) findViewById(R.id.getcode);
        ImageView login= (ImageView) findViewById(R.id.login);
        getcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = login_edit_code.getText().toString();
                pwd = login_edit_pwd.getText().toString();
                presenterLayer.getUser_Check_Rand(url,code,pwd);
                Log.d("www", code + "   " + pwd + "    ");
            }
        });
    }

    private void load() {
        //得到数据库的工具类对象
        instance = SharedPreferencesUtils.getInstance();
        //得到数据的URL
        url = (String) instance.getData(LoginActivity.this, "URL", "");
        Log.d("ooo","load:"+ url);
        usre = phone.getText().toString().trim();
        Log.d("ooo", usre);
        presenterLayer = new PresenterLayer();
        presenterLayer.setLoginView(this);
        Log.d("ooo", usre);
        presenterLayer.getUser_Reg(url,usre);
    }

    @Override
    public void getUserData(User_Reg user_reg) {
        String session18 = user_reg.getData().getSession();
        instance.saveData(LoginActivity.this,"session",session18);
        Log.d("ooo", session18+"adassr");
    }

    @Override
    public void getUser_CheckData(User_Check_Rand user_check_rand) {
        String uname = user_check_rand.getData().getUname();
        Log.d("www", uname);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }
}
