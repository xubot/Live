package com.example.administrator.live.Utils;

import com.example.administrator.live.Bean.Banners;
import com.example.administrator.live.Bean.First_hand;
import com.example.administrator.live.Bean.Host;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.Bean.List_Topic;
import com.example.administrator.live.Bean.List_Try;
import com.example.administrator.live.Bean.User_Check_Rand;
import com.example.administrator.live.Bean.User_Pwd_Login;
import com.example.administrator.live.Bean.User_Reg;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/25.
 */

public interface Api {
    @POST("/app/v1/first_hand")
    @FormUrlEncoded
    Observable<First_hand> getFirst_hand(@Field("type") String type,
                                         @Field("dev_id")String dev_id,
                                         @Field("ver_code")int ver_code,
                                         @Field("tick")String tick,
                                         @Field("sign")String sign);
    @POST("app/v1/get_host")
    @FormUrlEncoded
    Observable<Host> getHost(@Field("app_id") String app_id,
                             @Field("dev_id")String dev_id,
                             @Field("ver_code")int ver_code,
                             @Field("tick")String tick,
                             @Field("sign")String sign);
    @POST("/app/v1/list_banner")
    @FormUrlEncoded
    Observable<Banners> getBanner(@Field("app_id") String app_id,
                                  @Field("dev_id")String dev_id,
                                  @Field("ver_code")int ver_code,
                                  @Field("tick")String tick,
                                  @Field("sign")String sign);
    @POST("app/v1/list_try")
    @FormUrlEncoded
    Observable<List_Try> getList_try(@Field("app_id") String app_id,
                                     @Field("dev_id")String dev_id,
                                     @Field("ver_code")int ver_code,
                                     @Field("tick")String tick,
                                     @Field("page_size")int page_size,
                                     @Field("page_index")int page_index,
                                     @Field("sign")String sign);
    @POST("app/v1/list_course")
    @FormUrlEncoded
    Observable<List_Course> getList_course(@Field("app_id") String app_id,
                                           @Field("dev_id")String dev_id,
                                           @Field("ver_code")int ver_code,
                                           @Field("tick")String tick,
                                           @Field("page_size")int page_size,
                                           @Field("page_index")int page_index,
                                           @Field("sign")String sign);
    @POST("/app/v1/list_topic")
    @FormUrlEncoded
    Observable<List_Topic> getList_topic(@Field("app_id") String app_id,
                                         @Field("dev_id")String dev_id,
                                         @Field("ver_code")int ver_code,
                                         @Field("tick")String tick,
                                         @Field("page_size")int page_size,
                                         @Field("page_index")int page_index,
                                         @Field("sign")String sign);
    @POST("app/v1/user_reg")
    @FormUrlEncoded
    Observable<User_Reg> getUser_reg(@Field("app_id") String app_id,
                                     @Field("dev_id")String dev_id,
                                     @Field("ver_code")int ver_code,
                                     @Field("tick")String tick,
                                     @Field("mobile")String mobile,
                                     @Field("sign")String sign);
    @POST("app/v1/user_check_rand")
    @FormUrlEncoded
    Observable<User_Check_Rand> getUser_Check_Rand(@Field("app_id") String app_id,
                                                   @Field("dev_id")String dev_id,
                                                   @Field("ver_code")int ver_code,
                                                   @Field("tick")String tick,
                                                   @Field("session")String session,
                                                   @Field("rand")String rand,
                                                   @Field("passwd")String passwd,
                                                   @Field("sign")String sign);
    @POST("app/v1/user_pwd_login")
    @FormUrlEncoded
    Observable<User_Pwd_Login> getUser_Pwd_Login(@Field("app_id") String app_id,
                                                 @Field("dev_id")String dev_id,
                                                 @Field("ver_code")int ver_code,
                                                 @Field("tick")String tick,
                                                 @Field("mobile")String mobile,
                                                 @Field("passwd")String passwd,
                                                 @Field("sign")String sign);

}
