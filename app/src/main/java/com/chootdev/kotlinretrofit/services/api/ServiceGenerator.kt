package com.chootdev.kotlinretrofit.services.api

import com.chootdev.kotlinretrofit.helpers.Const
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Choota on 10/30/17.
 */
object ServiceGenerator {
    fun create(): APIInterface {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Const.BASE_URL)
                .build()

        return retrofit.create(APIInterface::class.java)
    }
}