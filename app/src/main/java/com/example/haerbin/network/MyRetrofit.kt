package com.example.haerbin.network

import retrofit2.Retrofit




class MyRetrofit {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://fanyi.youdao.com/") //设置网络请求的Url地址
        .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
}