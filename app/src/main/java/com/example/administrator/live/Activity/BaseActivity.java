package com.example.administrator.live.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.live.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        init();
        load();
    }
    public abstract void initView();
    protected abstract void init();
    protected abstract void load();
    public void setToolBar(String name, int img, int color,int menuitem){
        //设置ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title= (TextView) findViewById(R.id.titleName);
        title.setText(name);
        toolbar.setBackgroundColor(color);
        toolbar.inflateMenu(menuitem);
        toolbar.setNavigationIcon(img);
    }
    public void setTransparent(){
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }
}
