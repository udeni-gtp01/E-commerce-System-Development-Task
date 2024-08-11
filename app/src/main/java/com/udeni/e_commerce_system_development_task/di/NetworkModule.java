package com.udeni.e_commerce_system_development_task.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    @Singleton
    @Provides
    public static OkHttpClient provideHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(Converter.Factory converterFactory, OkHttpClient okHttpClient, String ApiUrl){
        return new Retrofit.Builder()
                .baseUrl(ApiUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Singleton
    @Provides
    public static Converter.Factory provideConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    public static String provideApiUrl(){
        return "https://spdevapi.nvision.lk/android_test/";
    }
}