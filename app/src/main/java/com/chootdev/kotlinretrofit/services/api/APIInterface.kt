package com.chootdev.kotlinretrofit.services.api

import com.chootdev.kotlinretrofit.models.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Choota on 10/30/17.
 */
interface APIInterface {
    @GET("search/users")
    fun search(@Query("q") query: String,
               @Query("page") page: Int = 1,
               @Query("per_page") perPage: Int = 100): Call<Result>
}