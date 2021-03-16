package com.example.haerbin.network;

import com.example.haerbin.bean.AnonuncementListBean;
import com.example.haerbin.bean.ComplaintBean;
import com.example.haerbin.bean.DepartMentDetailBean;
import com.example.haerbin.bean.DepartmentListBean;
import com.example.haerbin.bean.EmptyBean;
import com.example.haerbin.bean.ErrorBean;
import com.example.haerbin.bean.HandyListBean;
import com.example.haerbin.bean.LoginBean;
import com.example.haerbin.bean.NewsListBean;
import com.example.haerbin.bean.RegisterBean;
import com.example.haerbin.bean.RegisterCompanyBean;
import com.example.haerbin.bean.RegisterPerson2Bean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyService {
    @GET(Api.HANDYLIST)
    Call<HandyListBean> handyList();

    @GET(Api.HANDYLIST)
    Call<AnonuncementListBean> anonuncementList();

    @POST(Api.PHONE_LOGIN)
    @FormUrlEncoded
    Call<LoginBean> phoneLogin(@Field("mobile") String mobile, @Field("password") String password);

    @GET(Api.DEPARTMENT_LIST)
    Call<DepartmentListBean> departmentList(@Query("search") String search, @Query("page") int page);

    @GET(Api.DEPARTMENT_DETAIL)
    Call<DepartMentDetailBean> departmentDetail(@Query("department_id") String department_id);

    @POST(Api.REGISTER_PERSON_1)
    @FormUrlEncoded
    Call<RegisterBean> registerPersonOne(@Field("username") String username, @Field("password") String password);

    @POST(Api.REGISTER_PERSON_2)
    @FormUrlEncoded
    Call<RegisterPerson2Bean> registerPersonTwo(@Field("user_id") String user_id, @Field("realname") String realname, @Field("idtype") String idtype, @Field("idcard") String idcard, @Field("mobile") String mobile, @Field("verify_code") String verify_code);


    @POST(Api.REGISTER_COMPANY_1)
    @FormUrlEncoded
    Call<RegisterBean> registerCompanyOne(@Field("username") String username, @Field("password") String password);

    @POST(Api.REGISTER_COMPANY_2)
    @FormUrlEncoded
    Call<RegisterCompanyBean> registerCompanyTwo(@Field("user_id") String user_id, @Field("company_name") String company_name, @Field("credit_code") String credit_code, @Field("legal_idtype") String legal_idtype, @Field("legal_realname") String legal_realname, @Field("legal_idcard") String legal_idcard);

    @POST(Api.REGISTER_COMPANY_3)
    @FormUrlEncoded
    Call<RegisterPerson2Bean> registerCompanyThree(@Field("user_id") String user_id, @Field("company_id") String company_id, @Field("realname") String realname, @Field("idtype") String idtype, @Field("idcard") String idcard, @Field("mobile") String mobile, @Field("verify_code") String verify_code);


    @POST(Api.REGISTER_SEND_CODE)
    @FormUrlEncoded
    Call<EmptyBean> registerCode(@Field("mobile") String mobile);

    @POST(Api.EDITPHONE_SEND_CODE)
    @FormUrlEncoded
    Call<EmptyBean> editPhonCode(@Field("mobile") String mobile);

    @POST(Api.SEND_MESSAGE)
    @FormUrlEncoded
    Call<EmptyBean> sendMessage(@Field("mobile") String mobile);

    @POST(Api.EDITPHONE)
    @FormUrlEncoded
    Call<EmptyBean> editPhon(@Field("mobile") String mobile, @Field("verify_code") String verify_code);

    @POST(Api.NEWS_LIST)
    @FormUrlEncoded
    Call<NewsListBean> newsList(@Field("page") int page, @Field("search") String search);


    @POST(Api.EDIT_PASSWORD)
    @FormUrlEncoded
    Call<EmptyBean> editpsw(@Field("old_password") String old_password, @Field("new_password") String new_password);

    @POST(Api.POST_COMPLAINT)
    @FormUrlEncoded
    Call<EmptyBean> postComplaint(@Field("realname") String realname, @Field("idcard") String idcard,@Field("mobile") String mobile, @Field("address") String address,@Field("email") String email, @Field("type") String type,@Field("department") String department, @Field("theme") String theme,@Field("content") String content);

    @GET(Api.GET_MY_COMPLAINT)
    Call<ComplaintBean> getMyComplaint();


    @GET(Api.DEL_MY_COMPLAINT)
    Call<EmptyBean> delComplaint(@Query("complaint_id") String complaint_id);


    @POST(Api.POST_ERROR)
    @FormUrlEncoded
    Call<EmptyBean> postError(@Field("type") String type, @Field("department") String department, @Field("content") String content);


    @GET(Api.GET_ERROR)
    Call<ErrorBean> errorList();


    @GET(Api.DEL_ERROR)
    Call<EmptyBean> delError(@Query("fault_id") String fault_id);


    @POST(Api.FEEDBACK)
    @FormUrlEncoded
    Call<EmptyBean> postFeedBack(@Field("realname") String realname, @Field("mobile") String mobile, @Field("type") String type, @Field("content") String content, @Field("picarr") String picarr);

    @POST(Api.UPLOAD_FILE)
    Call<EmptyBean> upLoad(@Body RequestBody Body);

    @POST(Api.CREATE_ASK)
    @FormUrlEncoded
    Call<EmptyBean> createAsk(@Field("realname") String realname, @Field("idcard") String idcard,@Field("mobile") String mobile, @Field("address") String address,@Field("email") String email,@Field("department") String department, @Field("item") String item, @Field("theme") String theme,@Field("content") String content,@Field("verify_code") String verify_code);


}
