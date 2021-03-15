package com.example.haerbin.network;

import android.content.Context;

import com.chad.library.BuildConfig;
import com.diwaves.news.tools.SPToll;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.haerbin.network.Api.BASE_URL;

public class MyRetrofit {
    Retrofit retrofit;
    OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    public MyService service;
    Context context;

    public MyRetrofit(Context context) {
        this.context = context;
        setRetrofit();
    }

    private void setRetrofit() {
        LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .addHeader("token", new SPToll(context).getToken())
                .request("Request")
                .response("Response")
                .build();
        httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        httpClientBuilder.connectTimeout(6 * 1000, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//新的配置
                .baseUrl(BASE_URL)
                .client(httpClientBuilder.build())
                .build();
        service = retrofit.create(MyService.class);
    }


}
