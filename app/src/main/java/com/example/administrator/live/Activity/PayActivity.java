package com.example.administrator.live.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.PayUtils.PayResult;
import com.example.administrator.live.Utils.PayUtils.PayUtils;

public class PayActivity extends BaseActivity implements View.OnClickListener{
    private ImageView sure;
    private CheckBox zfb;
    private CheckBox wx;
    private CheckBox balance;
    private CheckBox apple;
    private int endprice;
    private TextView price;
    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(PayActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(PayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };


    @Override
    public void initView() {
        setContentView(R.layout.activity_pay);
        setToolBar("支付页面",R.mipmap.leftarrow,R.color.one,R.menu.zhihu_toolbar_menunull);
        Intent intent = getIntent();
        endprice = intent.getIntExtra("endprice", 0);
    }

    @Override
    protected void init() {
        price = (TextView) findViewById(R.id.price_buy);
        apple = (CheckBox) findViewById(R.id.check_apple_buy);
        balance = (CheckBox) findViewById(R.id.check_balance_buy);
        wx = (CheckBox) findViewById(R.id.check_wx_buy);
        zfb = (CheckBox)findViewById(R.id.check_zfb_buy);
        sure = (ImageView) findViewById(R.id.bt_sure_buy);
        sure.setOnClickListener(this);
        Log.d("tgb", endprice+"");
        price.setText("￥"+endprice);
    }

    @Override
    protected void load() {}

    public void alipay() {
        String orderinfo = PayUtils.getOrderInfo("测试商品", "购买一部手机",0.001+"");
        String signinfo = PayUtils.getSignInfo(orderinfo);
        final String totalInfo = PayUtils.getTotalInfo(orderinfo, signinfo);

        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(PayActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(totalInfo, true);
                Log.i("TAG", "走了pay支付方法.............");

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
    @Override
    public void setToolBar(String name, int img, int color, int menuitem) {
        super.setToolBar(name, img, color, menuitem);
    }

    @Override
    public void onClick(View v) {
        //微信支付
        if(wx.isChecked()){
            //startActivity(new Intent(Buy_activity.this,WX_activity.class));
            Toast.makeText(this, "暂无", Toast.LENGTH_SHORT).show();
            //苹果支付
        }else if(apple.isChecked()){
            //startActivity(new Intent(Buy_activity.this,Apple_activity.class));
            Toast.makeText(this, "暂无", Toast.LENGTH_SHORT).show();
            //余额支付
        }else if(balance.isChecked()){
            //startActivity(new Intent(Buy_activity.this,Banlance_activity.class));
            Toast.makeText(this, "暂无", Toast.LENGTH_SHORT).show();
            //支付宝支付
        }else if(zfb.isChecked()){

            //startActivity(new Intent(Buy_activity.this,Zfb_buy.class));
            alipay();
        }

    }
}
