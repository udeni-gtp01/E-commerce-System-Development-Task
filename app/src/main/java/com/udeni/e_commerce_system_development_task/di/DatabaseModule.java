package com.udeni.e_commerce_system_development_task.di;

import android.app.Application;

import androidx.room.Room;

import com.udeni.e_commerce_system_development_task.constant.AppConstant;
import com.udeni.e_commerce_system_development_task.database.AppDatabase;
import com.udeni.e_commerce_system_development_task.database.DatabaseDao;
import com.udeni.e_commerce_system_development_task.database.repository.DatabaseRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                AppDatabase.class,
                AppConstant.DB_NAME
        ).fallbackToDestructiveMigration().build();
    }

    /**
     * Provides the DAO (Data Access Object) for interacting with GitHub repository data
     * within the Room database.
     *
     * @param database The instance of the Room database.
     * @return The DAO object of type `GitHubRepositoryDao`.
     */
    @Singleton
    @Provides
    public DatabaseDao provideCustomerDao(AppDatabase database) {
        return database.databaseDao();
    }

    @Singleton
    @Provides
    public DatabaseRepository provideCustomerRepository(DatabaseDao databaseDao, Executor executor) {
        return new DatabaseRepository(databaseDao, executor);
    }

    @Singleton
    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }
}
