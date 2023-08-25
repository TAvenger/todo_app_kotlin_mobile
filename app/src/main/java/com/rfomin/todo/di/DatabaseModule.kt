package com.rfomin.todo.di

import android.content.Context
import com.rfomin.todo.database.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideTaskDao(taskDatabase: TaskDatabase) = taskDatabase.getTaskDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) = TaskDatabase.getInstance(appContext)
}