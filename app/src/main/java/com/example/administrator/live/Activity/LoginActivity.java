package com.example.administrator.live.Activity;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.live.Bean.User_Check_Rand;
import com.example.administrator.live.Bean.User_Reg;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.LoginView;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;


public class LoginActivity extends BaseActivity implements LoginView{
    //得到数据库的工具类对象
    private SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance();
    private String url;
    private String usre;
    private String code;
    private String pwd;
    private EditText phone;
    private PresenterLayer presenterLayer;
    private EditText login_edit_code;
    private EditText login_edit_pwd;
    private int time=10;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(time==0){
                Toast.makeText(LoginActivity.this, "您的验证码是：9998", Toast.LENGTH_SHORT).show();
                getcode.setText("重新获取");
                time=10;
            }else {
                time--;
                getcode.setText(time+"秒");
                handler.sendEmptyMessageDelayed(time,1000);
            }
        }
    };
    private TextView getcode;

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
        setToolBar("注册页面",R.mipmap.leftarrow,R.color.one,R.menu.zhihu_toolbar_menunull);
        setTransparent();
        //得到数据的URL
        url = (String) instance.getData(LoginActivity.this, "URL", "");
        Log.d("ooo", url);
    }

    @Override
    public void setTransparent() {
        super.setTransparent();
    }

    @Override
    protected void init() {
        phone = (EditText) findViewById(R.id.login_edit_usre);
        login_edit_code = (EditText) findViewById(R.id.login_edit_code);
        login_edit_pwd = (EditText) findViewById(R.id.login_edit_pwd);
        getcode = (TextView) findViewById(R.id.getcode);
        ImageView login= (ImageView) findViewById(R.id.login);
        getcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ooo","load:"+ url);
                usre = phone.getText().toString().trim();
                Log.d("ooo", usre);
                presenterLayer.getUser_Reg(url,usre);
                getcode.setText(time+"秒");
                handler.sendEmptyMessageDelayed(time,1000);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = login_edit_code.getText().toString();
                pwd = login_edit_pwd.getText().toString();
                Log.d("www", code + "   " + pwd + "    ");
                presenterLayer.getUser_Check_Rand(url,code,pwd);
            }
        });
    }

    @Override
    protected void load() {
        presenterLayer = new PresenterLayer();
        presenterLayer.setLoginView(this);
    }

    @Override
    public void setToolBar(String name, int img, int color,int menuitem) {
        super.setToolBar(name, img, color,menuitem);
    }

    @Override
    public void getUserData(User_Reg user_reg) {
        String session = user_reg.getData().getSession();
        instance.saveData(LoginActivity.this,"session",session);
        Log.d("ooo", session+"adassr");
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
