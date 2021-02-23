package com.example.haerbin.network;

import com.example.haerbin.bean.AnonuncementListBean;
import com.example.haerbin.bean.HandyListBean;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {
    @GET(Api.HANDYLIST)
    Call<HandyListBean> handyList();

    @GET(Api.HANDYLIST)
    Call<AnonuncementListBean> anonuncementList();


}
