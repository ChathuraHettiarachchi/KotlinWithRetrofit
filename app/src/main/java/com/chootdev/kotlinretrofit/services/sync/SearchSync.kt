package com.chootdev.kotlinretrofit.services.sync

import com.chootdev.kotlinretrofit.models.Result
import com.chootdev.kotlinretrofit.services.api.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Choota on 10/30/17.
 */
class SearchSync(callback: SearchCallback) {

    private var callback : SearchCallback? = null

    init {
        this.callback = callback
    }

    fun getSearchResult(query: String, page: Int = 1, per_page: Int = 100) {
        ServiceGenerator.create()
                .search(query, page, per_page)
                .enqueue(object : Callback<Result> {
                    override fun onFailure(call: Call<Result>?, t: Throwable?) {
                        callback?.onSearchResponseFound(false, null)
                    }

                    override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                        callback?.onSearchResponseFound(true, response?.body())
                    }
                })
    }

    interface SearchCallback {
        fun onSearchResponseFound(status: Boolean, response: Result?)
    }
}