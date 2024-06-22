package com.snekbyte.mhwarmor.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.snekbyte.mhwarmor.data.MHWorldApi
import com.snekbyte.mhwarmor.data.RepositoryImpl
import com.snekbyte.mhwarmor.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private const val BASE_URL = "https://mhw-db.com/"

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideMHWorldApi(retrofit: Retrofit): MHWorldApi {
        return retrofit.create(MHWorldApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MHWorldApi): Repository {
        return RepositoryImpl(api)
    }
}
