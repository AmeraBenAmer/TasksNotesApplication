package com.engamsba.noteapplication.di

import android.app.Application
import android.content.Context
import com.engamsba.noteapplication.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    internal  fun provideContext(application: Application): Context{
        return application
    }
//    @Provides
//    @Singleton
//    internal  fun provideRepository(repository: MainRepository): MainRepository{
//        return repository
//    }
}