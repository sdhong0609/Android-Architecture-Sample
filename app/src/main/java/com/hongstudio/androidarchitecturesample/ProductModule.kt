package com.hongstudio.androidarchitecturesample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModelModule {

    @Singleton
    @Provides
    fun provideProductModel(): ProductContract.Model {
        return ProductModel()
    }
}
