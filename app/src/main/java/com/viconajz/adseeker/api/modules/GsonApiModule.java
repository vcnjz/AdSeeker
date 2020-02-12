package com.viconajz.adseeker.api.modules;

import com.viconajz.adseeker.api.Api;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GsonApiModule {
    private static final String BASE_URL = "http://pressa-api.imb2bs.com/api/v1/";

    @Singleton
    @Provides
    Api provideApiService() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS);

        httpClientBuilder.addInterceptor(chain -> {
            Request original = chain.request();
            Request request;
                request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();

            return chain.proceed(request);
        });


        OkHttpClient client = httpClientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(Api.class);
    }
}
