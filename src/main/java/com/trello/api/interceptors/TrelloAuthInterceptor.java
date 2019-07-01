package com.trello.api.interceptors;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;



public class TrelloAuthInterceptor implements Interceptor {


    private static final String KEY = "591ebf2e0e5476dc6a8d0e564450bf44";
    private static final String TOKEN = "46b92131c450dcc1bdcf9bc7a1f64e71cfb7895e591133056b6ebc68b67ea1a6";


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", KEY)
                .addQueryParameter("token", TOKEN)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }



}