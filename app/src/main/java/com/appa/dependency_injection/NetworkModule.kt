package com.appa.dependency_injection

import com.appa.data.remote.api.MessagesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun provideMessagesApi(): MessagesApi {
        return provideRetrofitClient().create(MessagesApi::class.java)
    }

    private fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}