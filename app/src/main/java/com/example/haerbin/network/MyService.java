package com.example.haerbin.network;

import com.example.haerbin.base.EmptyBean;
import com.example.haerbin.bean.AnonuncementListBean;
import com.example.haerbin.bean.DepartMentDetailBean;
import com.example.haerbin.bean.DepartmentListBean;
import com.example.haerbin.bean.HandyListBean;
import com.example.haerbin.bean.LoginBean;

import retrofit2.Call;
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
}
