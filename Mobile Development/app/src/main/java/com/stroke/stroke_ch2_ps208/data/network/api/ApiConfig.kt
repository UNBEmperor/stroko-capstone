package com.stroke.stroke_ch2_ps208.data.network.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val BASE_URL = "https://stroko-api-dot-capstone-stroko.et.r.appspot.com"
    private const val BASE_URL2 = "https://backend-ml-qeg7ziwx4q-et.a.run.app"

    fun apiService(accessToken: String = ""): ApiService {
        val interceptor = Interceptor {
            var request = it.request()
            request = request.newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .addHeader("x-access-token", "")
                .addHeader("x-access-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzMsImlhdCI6MTcwMzE2OTU0NCwiZXhwIjoxNzAzMjU1OTQ0fQ.hii2Ue79Rt_eQouoRDyAP3Kps5FamJJUaC2FaFKytrw")
                .build()
            it.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}