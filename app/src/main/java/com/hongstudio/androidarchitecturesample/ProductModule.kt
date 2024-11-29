package com.hongstudio.androidarchitecturesample

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ProductModule {

    @Binds
    abstract fun bindActivity(activity: ProductActivity): ProductContract.View

    @Binds
    abstract fun bindPresenter(impl: ProductPresenter): ProductContract.Presenter

    @Binds
    abstract fun bindModel(impl: ProductModel): ProductContract.Model
}

@Module
@InstallIn(ActivityComponent::class)
object ProductActivityModule {

    @Provides
    fun provideActivity(activity: Activity): ProductActivity {
        return activity as ProductActivity
    }
}

@Module
@InstallIn(ActivityComponent::class)
object ProductModelModule {

    @Provides
    fun provideModel(): ProductModel {
        return ProductModel()
    }
}