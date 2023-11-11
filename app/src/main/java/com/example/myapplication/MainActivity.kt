package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchData()


    }

    private fun fetchData() {
        val myApi = MyApiClient.myApi

        val call: Call<List<Repo>> = myApi.listRepos("octocat")

        call.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                if (response.isSuccessful) {
                    // Handle successful response
                    val repos: List<Repo>? = response.body()
                    // Do something with the data
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}