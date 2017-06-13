package com.example.administrator.live.MVPMethods.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.live.Bean.Banners;
import com.example.administrator.live.Bean.Detail_Course;
import com.example.administrator.live.Bean.First_hand;
import com.example.administrator.live.Bean.Host;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.Bean.List_Topic;
import com.example.administrator.live.Bean.List_Try;
import com.example.administrator.live.Bean.User_Check_Rand;
import com.example.administrator.live.Bean.User_Pwd_Login;
import com.example.administrator.live.Bean.User_Reg;
import com.example.administrator.live.MVPMethods.Moudel.MoudelLayer;
import com.example.administrator.live.MVPMethods.View.Fragmentview;
import com.example.administrator.live.MVPMethods.View.LogView;
import com.example.administrator.live.MVPMethods.View.LoginView;
import com.example.administrator.live.MVPMethods.View.ShowView;
import com.example.administrator.live.MVPMethods.View.ViewLayer;
import com.example.administrator.live.Utils.Api;
import com.example.administrator.live.Utils.First_handUtils.DeviceUtil;
import com.example.administrator.live.Utils.First_handUtils.EncoderByMd5;
import com.example.administrator.live.Utils.First_handUtils.TimeUtil;
import com.example.administrator.live.Utils.STRINGBUFFER;
import com.example.administrator.live.Utils.SharedPreferencesUtils;
import com.example.administrator.live.Utils.URLCLASS;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/5/25.
 */

public class PresenterLayer {
    private ViewLayer viewLayer;
    private Fragmentview fragmentView;
    private final MoudelLayer moudelLayer;
    private Context context;
    private SharedPreferencesUtils instance = SharedPreferencesUtils.getInstance();
    private String private_key;
    private String app_id;
    private String url;
    private Context fContext;
    private LoginView loginView;
    private Context logincontext;
    private Context logcontext;
    private String session;
    private LogView logView;
    private ShowView showView;
    private Context showcontext;

    //P层构造器
    public PresenterLayer() {
        moudelLayer = new MoudelLayer();
    }
    //得到View对象
    public void setViewLayer(ViewLayer viewLayer) {
        this.viewLayer = viewLayer;
        context = viewLayer.getActivityContext();
    }
    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
        Log.d("ooo", "111111");
        logincontext = loginView.getActivityContext();
        Log.d("ooo", "22222");
        //得到private_key
        private_key = (String) instance.getData(logincontext, "private_key", "1");
        //得到app_id
        app_id = (String) instance.getData(logincontext, "app_id", "1");
    }
    public void setFragmentView(Fragmentview fragmentView) {
        this.fragmentView = fragmentView;
        fContext = fragmentView.getActivityContext();
        //得到private_key
        private_key = (String) instance.getData(fContext, "private_key", "1");
        //得到app_id
        app_id = (String) instance.getData(fContext, "app_id", "1");
    }
    public void setLogView(LogView logView) {
        this.logView = logView;
        logcontext = logView.getActivityContext();
        //得到private_key
        private_key = (String) instance.getData(logcontext, "private_key", "1");
        //得到app_id
        app_id = (String) instance.getData(logcontext, "app_id", "1");
    }
    public void setShowView(ShowView showView) {
        this.showView = showView;
        showcontext = showView.getActivityContext();
        //得到private_key
        private_key = (String) instance.getData(showcontext, "private_key", "1");
        //得到app_id
        app_id = (String) instance.getData(showcontext, "app_id", "1");
    }


    //得到首次握手和导向的数据
    public void getFirst_hand() {
        Log.d("zz1", "getResponse");
        Retrofit retrofit = moudelLayer.getFirst_hand_HostData();
        Api api = retrofit.create(Api.class);
        Log.d("zz1", "dfdsfffsd");
        Observable<First_hand> first_hand = api.getFirst_hand(URLCLASS.TYPE,
                DeviceUtil.getLocaldeviceId(context),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(),
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                        EncoderByMd5.appFistHandAddPwd(
                                STRINGBUFFER.setFirst_hand(context)))));
        first_hand.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<First_hand>() {
                    @Override
                    public void accept(@NonNull First_hand first_hand) throws Exception {
                        viewLayer.getFirst_hand(first_hand);
                        Log.d("zzz", "onNext++++344334++++");
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<First_hand, ObservableSource<Host>>() {
                    @Override
                    public ObservableSource<Host> apply(@NonNull First_hand first_hand) throws Exception {
                        //得到private_key
                        private_key = (String) instance.getData(context, "private_key", "1");
                        //得到app_id
                        app_id = (String) instance.getData(context, "app_id", "1");
                        Log.d("zzz5", "private_key:" + private_key + "     app_id:" + app_id);

                        Retrofit retrofit = moudelLayer.getFirst_hand_HostData();
                        Api api = retrofit.create(Api.class);
                        return api.getHost(app_id,
                                DeviceUtil.getLocaldeviceId(context),
                                URLCLASS.VER_CODE, TimeUtil.timeFormatYuzhilai(),
                                EncoderByMd5.appFistHandToUpperCase(
                                        EncoderByMd5.md5Password(
                                                EncoderByMd5.appFistHandAddPwd(
                                                        STRINGBUFFER.setHost(
                                                                private_key,app_id,context)))));
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Host>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Host host) {
                        Log.d("zzz", "onNext++++++++");
                        viewLayer.getHost(host);

                        viewLayer.success();
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
    //得到Banner的值
    public void getBanner(String url) {
        Log.d("zzz", "getBanner:" + url);
        Retrofit bannerData = moudelLayer.getBannerData(url);
        Api api = bannerData.create(Api.class);
        Observable<Banners> bannerObservable = api.getBanner(app_id,
                DeviceUtil.getLocaldeviceId(fContext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(),
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setBanner(
                                                private_key,app_id,fContext)))));
        Log.d("zzz", "中间");
        bannerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Banners>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Banners banner) {
                        fragmentView.setBanner(banner);
                        Log.d("zzz", "bannerObservablebanner");
                    }
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //得到试听的值
    public void getList_Try(String url) {
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Observable<List_Try> list_try = api.getList_try(app_id,
                DeviceUtil.getLocaldeviceId(fContext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(), 4, 0,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                          STRINGBUFFER.setList_Try(
                                                private_key,app_id,fContext)))));
        list_try.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List_Try>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List_Try list_try) {
                        Log.d("xxx", list_try + "v    ddddddddd");
                        fragmentView.setTryListview(list_try);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //得到精品听的值
    public void getList_Course(String url) {
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Observable<List_Course> List_course = api.getList_course(app_id,
                DeviceUtil.getLocaldeviceId(fContext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(), 4, 0,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setList_Try(
                                                private_key,app_id,fContext)))));
        List_course.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List_Course>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List_Course List_course) {
                        Log.d("xxx", List_course + "v    ddddddddd");
                        fragmentView.setCourseListview(List_course);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //得到精品专辑听的值
    public void getList_Topic(String url) {
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Observable<List_Topic> List_course = api.getList_topic(app_id,
                DeviceUtil.getLocaldeviceId(fContext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(), 4, 0,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setList_Try(
                                                private_key,app_id,fContext)))));
        List_course.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List_Topic>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List_Topic List_topic) {
                        Log.d("xxx", List_topic + "v    ddddddddd");
                        fragmentView.setTopicListview(List_topic);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //得到session的方法
    public void getUser_Reg(String url,String phone){
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Log.d("ooo", "session18");
        Log.d("ooo", phone);
        Log.d("ooo", app_id);
        Observable<User_Reg> User_Reg = api.getUser_reg(app_id,
                DeviceUtil.getLocaldeviceId(logincontext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(),
                phone,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setUser_Reg(
                                                private_key,app_id,logincontext,phone)))));
        User_Reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User_Reg>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User_Reg user_reg) {
                        int ret = user_reg.getRet();
                        switch (ret){
                            case 0:
                                loginView.getUserData(user_reg);
                                Log.d("ooo", user_reg + "hahahaha");
                                break;
                            case -5:
                                Toast.makeText(logincontext, "手机号码格式错误（不是11位）", Toast.LENGTH_SHORT).show();
                                break;
                            case -6:
                                Toast.makeText(logincontext, "手机号码已注册", Toast.LENGTH_SHORT).show();
                                break;
                            case -10:
                                Toast.makeText(logincontext, "手机号码格式错误", Toast.LENGTH_SHORT).show();
                                break;
                        }



                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //注册的方法
    public void getUser_Check_Rand(String url,String code,String pwd){
        session = (String) instance.getData(logincontext, "session", "1");
        Log.d("www", session);
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Log.d("www", code);
        Log.d("www", pwd);
        Observable<User_Check_Rand> User_Reg = api.getUser_Check_Rand(app_id,
                DeviceUtil.getLocaldeviceId(logincontext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(),
                session,code,pwd,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setUser_Check_Rand(
                                                private_key,app_id,logincontext,session,code,pwd)))));
        User_Reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User_Check_Rand>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User_Check_Rand user_Check_Rand) {
                        int ret = user_Check_Rand.getRet();
                        switch (ret){
                            case 0:
                                loginView.getUser_CheckData(user_Check_Rand);
                                Log.d("www", user_Check_Rand.getData().getUname() + ":hahahaha");
                                break;
                            case -4:
                                Toast.makeText(logincontext, "无效的session", Toast.LENGTH_SHORT).show();
                                break;
                            case -5:
                                Toast.makeText(logincontext, "验证码错误", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //登录 的方法
    public void getUser_Pwd_Login(String url,String usre,String pwd){
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Log.d("qqq", usre);
        Log.d("qqq", pwd);
        Observable<User_Pwd_Login> User_Reg = api.getUser_Pwd_Login(app_id,
                DeviceUtil.getLocaldeviceId(logcontext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(),
                usre,pwd,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setUser_Pwd_Login(
                                                private_key,app_id,logcontext,usre,pwd)))));
        User_Reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User_Pwd_Login>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User_Pwd_Login user_pwd_login) {
                        int ret = user_pwd_login.getRet();
                        switch (ret){
                            case 0 :
                                logView.getuser_pwd_login(user_pwd_login);
                                Log.d("qqq", user_pwd_login.getData().getSession() + ":hahahaha");
                                break;
                            case -5:
                                Toast.makeText(logcontext, "手机号未注册", Toast.LENGTH_SHORT).show();
                                break;
                            case -7:
                                Toast.makeText(logcontext, "密码错误", Toast.LENGTH_SHORT).show();
                                break;
                            case -9:
                                Toast.makeText(logcontext, "连续密码以错5次，将禁止15分钟", Toast.LENGTH_SHORT).show();
                                break;
                            case -10:
                                Toast.makeText(logcontext, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //详情的方法
    public void getDetail_Course(String url,String object_id){
        Retrofit retrofit = moudelLayer.getBannerData(url);
        Api api = retrofit.create(Api.class);
        Observable<Detail_Course> User_Reg = api.getDetail_Course(app_id,
                DeviceUtil.getLocaldeviceId(showcontext),
                URLCLASS.VER_CODE,
                TimeUtil.timeFormatYuzhilai(),
                object_id,
                EncoderByMd5.appFistHandToUpperCase(
                        EncoderByMd5.md5Password(
                                EncoderByMd5.appFistHandAddPwd(
                                        STRINGBUFFER.setDetail_Course(
                                                private_key,app_id,showcontext,object_id)))));
        User_Reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Detail_Course>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Detail_Course detail_course) {
                        showView.getdetail_course(detail_course);
                        Log.d("qqq", detail_course.getData().getTitle() + ":hahahaha");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
