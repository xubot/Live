package com.example.administrator.live.Activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.live.Bean.First_hand;
import com.example.administrator.live.Bean.Host;
import com.example.administrator.live.Fragment.CouresFragment;
import com.example.administrator.live.Fragment.LearningFragment;
import com.example.administrator.live.Fragment.MienFragment;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.ViewLayer;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener,ViewLayer {

    private Fragment fragment;
    private LearningFragment learningFragment;
    private CouresFragment couresFragment;
    private MienFragment mienFragment;
    private List<TextView> textViewList=new ArrayList<>();
    private int[] clickAfter=new int[]{R.mipmap.selectedlearnimg,R.mipmap.selectedstudy,R.mipmap.selectedmine};
    private int[] clickBefore =new int[]{R.mipmap.defaultlearnimg,R.mipmap.defaultstudy,R.mipmap.defaultmine};
    private List<LinearLayout> linearLayoutList=new ArrayList<>();
    private List<ImageView> imageViewList=new ArrayList<>();
    //得到保存数据的类
    private SharedPreferencesUtils instance=SharedPreferencesUtils.getInstance();
    //加载布局
    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        setToolBar("不一样的世界",R.mipmap.leftarrow,R.color.one,R.menu.zhihu_toolbar_menu);
    }
    //设置toolBar
    @Override
    public void setToolBar(String name,int img,int color,int menuitem) {
        super.setToolBar(name,img,color,menuitem);
    }
    //得到控件
    @Override
    public void init() {
        //得到控件(LinearLayout的控件)
        LinearLayout ll_learnimg = (LinearLayout) findViewById(R.id.ll_learnimg);
        LinearLayout ll_study = (LinearLayout) findViewById(R.id.ll_study);
        LinearLayout ll_mine = (LinearLayout) findViewById(R.id.ll_mine);
        //得到控件(TextView)
        TextView learning= (TextView) findViewById(R.id.learning);
        TextView course= (TextView) findViewById(R.id.course);
        TextView mine= (TextView) findViewById(R.id.mine);
        //得到下面图片的控件
        ImageView img_learning = (ImageView) findViewById(R.id.img_learning);
        ImageView img_study = (ImageView) findViewById(R.id.img_study);
        ImageView img_mine = (ImageView) findViewById(R.id.img_mine);
        /*//设置ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);
        toolbar.setNavigationIcon(R.mipmap.leftarrow);*/
        //向集合中赋值（ textView）
        textViewList.add(learning);
        textViewList.add(course);
        textViewList.add(mine);
        //向集合中赋值（imageView）
        imageViewList.add(img_learning);
        imageViewList.add(img_study);
        imageViewList.add(img_mine);
        //向集合中赋值（LayoutList）
        linearLayoutList.add(ll_learnimg);
        linearLayoutList.add(ll_study);
        linearLayoutList.add(ll_mine);

        for(LinearLayout l:linearLayoutList){
            l.setOnClickListener(this);
        }
    }
    //得到P层数据的方法
    @Override
    public void load() {
        PresenterLayer presenterLayer = new PresenterLayer();
        presenterLayer.setViewLayer(this);
        presenterLayer.getFirst_hand();
    }

    //点击监听的地方
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_learnimg :
                if (learningFragment==null){
                    learningFragment =new LearningFragment();
                }
                addFragment(learningFragment);
                setBackground(0);
                break;
            case R.id.ll_study :
                if (couresFragment==null){
                    couresFragment =new CouresFragment();
                }
                addFragment(couresFragment);
                setBackground(1);
                break;
            case R.id.ll_mine :
                if (mienFragment==null){
                    mienFragment =new MienFragment();
                }
                addFragment(mienFragment);
                setBackground(2);
                break;
        }
    }
    //添加fragment布局
    public void addFragment(Fragment f) {
        //得到fragment的管理类
        FragmentManager manager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();
        //赋值
        if (fragment!=null){
            transaction.hide(fragment);
        }if(!f.isAdded()){
            //添加当前fragment
            transaction.add(R.id.fl,f);
        }
        //显示当前事务
        transaction.show(f);
        //提交事务
        transaction.commit();
        //给空槽赋值
        fragment=f;
    }
    //设置颜色（点击时）
    public void setBackground(int index) {
        for(int i=0;i<textViewList.size();i++)
        {
            if(i==index)
            {
                textViewList.get(i).setTextColor(Color.BLUE);
                imageViewList.get(i).setImageResource(clickAfter[i]);
            }
            else
            {
                textViewList.get(i).setTextColor(Color.BLACK);
                imageViewList.get(i).setImageResource(clickBefore[i]);
            }
        }
    }
    //得到P层数据的方法
    //得到第一次握手的数据
    @Override
    public void getFirst_hand(First_hand first_hand) {
        String private_key = first_hand.getData().getPrivate_key();
        String app_id = first_hand.getData().getApp_id();
        Log.d("zzz", private_key);
        Log.d("zzz", app_id);
        //向SharedPreferences存值
        instance.saveData(this,"private_key",private_key);
        instance.saveData(this,"app_id",app_id);
        Log.d("zzz", "First_hand成功");
    }
    //得到连接导向后的数据
    @Override
    public void getHost(Host host) {
        Log.d("zzz3", host+"");
        Log.d("zzz3", host.getHostBean()+"");
        String url_host = host.getHostBean().getUrl_host();
        instance.saveData(this,"URL",url_host);
        Log.d("zzz3", "host:" + url_host );
        Log.d("zzz", "host成功");
    }
    //得到上下文返回上下文
    @Override
    public Context getActivityContext() {
        return this;
    }
    //请求成功时启动fragment
    @Override
    public void success() {
        //初次进入页面
        if (learningFragment==null){
            learningFragment =new LearningFragment();
        }
        addFragment(learningFragment);
        setBackground(0);
    }
}
