package com.chootdev.kotlinretrofit.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chootdev.kotlinretrofit.R
import com.chootdev.kotlinretrofit.models.Result
import com.chootdev.kotlinretrofit.services.sync.SearchSync
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchSync.SearchCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SearchSync(this).getSearchResult("language:Java")
    }

    override fun onSearchResponseFound(status: Boolean, response: Result?) {
        for (user in response?.items!!) {
            tvData.text = "${tvData.text} \n ${user.toString()}"
        }
    }
}
