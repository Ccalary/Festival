package com.example.caohouhong.festival.request;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by caohouhong on 17/5/12.
 */

public class ApiConfig {
    private static Retrofit mRetrofit;

    public static Retrofit getDefault() {

        if (mRetrofit == null) {
            //配置请求log
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            //配置OKHttp
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(logging).build();
            builder.connectTimeout(60, TimeUnit.SECONDS); //链接超时60s
            builder.readTimeout(20, TimeUnit.SECONDS); //读取缓存超时20s
            builder.writeTimeout(20, TimeUnit.SECONDS); //写入缓存超时20s
            builder.retryOnConnectionFailure(true); //错误重连

            OkHttpClient client = builder.build();
            mRetrofit = new Retrofit.Builder()
                    //配置请求的基础请求地址，以"／"结尾
                    .baseUrl(URLConfig.BASE_ADDRESS)
                    //配置成用Gson解析
                    .addConverterFactory(GsonConverterFactory.create())
                    //添加RxJava支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
        }

        return mRetrofit;
    }
}
