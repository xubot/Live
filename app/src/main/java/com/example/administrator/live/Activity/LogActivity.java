package com.example.administrator.live.Activity;

import android.content.Context;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.live.Bean.MessageEvent;
import com.example.administrator.live.Bean.User_Pwd_Login;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.LogView;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;

import de.greenrobot.event.EventBus;

public class LogActivity extends BaseActivity implements LogView,View.OnClickListener{
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
        setTransparent();
        //得到数据的URL
        url = (String) instance.getData(LogActivity.this, "URL", "");
        Log.d("qqq","load:"+ url);
    }

    @Override
    public void setTransparent() {
        super.setTransparent();
    }

    @Override
    protected void init() {
        log_edit_usre = (EditText) findViewById(R.id.log_edit_usre);
        log_edit_pwd = (EditText) findViewById(R.id.log_edit_pwd);
        ImageView log= (ImageView) findViewById(R.id.log);
        log.setOnClickListener(this);
        ImageView phonelog= (ImageView) findViewById(R.id.phonelog);
        phonelog.setOnClickListener(this);
        TextView forget= (TextView) findViewById(R.id.forget);
        forget.setOnClickListener(this);
        LinearLayout weixin_ll= (LinearLayout) findViewById(R.id.weixin_ll);
        weixin_ll.setOnClickListener(this);
        LinearLayout qq_ll= (LinearLayout) findViewById(R.id.qq_ll);
        qq_ll.setOnClickListener(this);
        final CheckBox show_pwd= (CheckBox) findViewById(R.id.show_pwd);
        //显示与隐藏密码
        show_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //如果选中，显示密码
                    log_edit_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    show_pwd.setBackgroundResource(R.mipmap.showpassword);
                }else{
                    //否则隐藏密码
                    log_edit_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    show_pwd.setBackgroundResource(R.mipmap.loginnopassword);
                }
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
        EventBus.getDefault().post(new MessageEvent(true));
        LogActivity.this.finish();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }
    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.log:
                String usre = log_edit_usre.getText().toString().trim();
                String pwd = log_edit_pwd.getText().toString();
                Log.d("qqq", "usre:"+usre+"   "+"pwd:"+pwd);
                presenterLayer.getUser_Pwd_Login(url,usre,pwd);
                break;
            case R.id.phonelog:
                startActivity(new Intent(LogActivity.this,LoginActivity.class));
                break;
            case R.id.forget:
                Toast.makeText(this, "正在更新中", Toast.LENGTH_SHORT).show();
                break;
            case R.id.weixin_ll:
                Toast.makeText(this, "正在更新中", Toast.LENGTH_SHORT).show();
                break;
            case R.id.qq_ll:
                Toast.makeText(this, "正在更新中", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
