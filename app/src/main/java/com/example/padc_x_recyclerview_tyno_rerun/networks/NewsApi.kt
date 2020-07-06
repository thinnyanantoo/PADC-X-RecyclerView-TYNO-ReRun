package com.example.padc_x_recyclerview_tyno_rerun.networks

import com.example.padc_x_recyclerview_tyno_rerun.networks.responses.GetAllNewsResponse
import com.example.padc_x_recyclerview_tyno_rerun.utils.GET_NEWS
import com.example.padc_x_recyclerview_tyno_rerun.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {
    @FormUrlEncoded
    @POST(GET_NEWS)
    fun getAllNews(@Field(PARAM_ACCESS_TOKEN)accessToken : String): Call<GetAllNewsResponse>
}