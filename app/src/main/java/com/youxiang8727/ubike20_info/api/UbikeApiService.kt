package com.youxiang8727.ubike20_info.api

import com.youxiang8727.ubike20_info.model.UbikeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface UbikeApiService {
    companion object{
        const val URL: String = "https://tcgbusfs.blob.core.windows.net"
    }

    @GET("/dotapp/youbike/v2/youbike_immediate.json")
    suspend fun getData(): Response<List<UbikeResponse>>
}