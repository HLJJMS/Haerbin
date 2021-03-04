package com.example.haerbin.network;

import com.example.haerbin.bean.AnonuncementListBean;
import com.example.haerbin.bean.DepartMentDetailBean;
import com.example.haerbin.bean.DepartmentListBean;
import com.example.haerbin.bean.EmptyBean;
import com.example.haerbin.bean.HandyListBean;
import com.example.haerbin.bean.LoginBean;
import com.example.haerbin.bean.RegisterBean;
import com.example.haerbin.bean.RegisterCompanyBean;
import com.example.haerbin.bean.RegisterPerson2Bean;

import retrofit2.Call;
import retrofit2.Response;
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
    Call<DepartmentListBean> departmentList(@Query("search") String search,@Query("page") int page);

    @GET(Api.DEPARTMENT_DETAIL)
    Call<DepartMentDetailBean> departmentDetail(@Query("department_id") String department_id);

    @POST(Api.REGISTER_PERSON_1)
    @FormUrlEncoded
    Call<RegisterBean> registerPersonOne(@Field("username") String username, @Field("password") String password);

    @POST(Api.REGISTER_PERSON_2)
    @FormUrlEncoded
    Call<RegisterPerson2Bean> registerPersonTwo(@Field("user_id") String user_id, @Field("realname") String realname,@Field("idtype") String idtype, @Field("idcard") String idcard,@Field("mobile") String mobile, @Field("verify_code") String verify_code);


    @POST(Api.REGISTER_COMPANY_1)
    @FormUrlEncoded
    Call<RegisterBean> registerCompanyOne(@Field("username") String username, @Field("password") String password);

    @POST(Api.REGISTER_COMPANY_2)
    @FormUrlEncoded
    Call<RegisterCompanyBean> registerCompanyTwo(@Field("user_id") String user_id, @Field("company_name") String company_name, @Field("credit_code") String credit_code, @Field("legal_idtype") String legal_idtype, @Field("legal_realname") String legal_realname, @Field("legal_idcard") String legal_idcard);

    @POST(Api.REGISTER_COMPANY_3)
    @FormUrlEncoded
    Call<RegisterPerson2Bean> registerCompanyThree(@Field("user_id") String user_id,  @Field("company_id") String company_id,  @Field("realname") String realname,  @Field("idtype") String idtype,  @Field("idcard") String idcard,  @Field("mobile") String mobile, @Field("verify_code") String verify_code);


    @POST(Api.REGISTER_SEND_CODE)
    @FormUrlEncoded
    Call<EmptyBean> registerCode(@Field("mobile") String mobile);

}
