package com.udeni.e_commerce_system_development_task.di;

import com.udeni.e_commerce_system_development_task.data.remote.repository.OrderApiRepository;
import com.udeni.e_commerce_system_development_task.data.remote.service.OrderApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Singleton
    @Provides
    public static OrderApiRepository provideOrderApiRepository(OrderApiService orderApiService) {
        return new OrderApiRepository(orderApiService);
    }

    @Singleton
    @Provides
    public static OrderApiService provideOrderApiService(Retrofit retrofit) {
        return retrofit.create(OrderApiService.class);
    }
}
