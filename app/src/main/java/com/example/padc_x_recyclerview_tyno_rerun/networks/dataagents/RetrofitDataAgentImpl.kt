package com.example.padc_x_recyclerview_tyno_rerun.networks.dataagents

import com.example.padc_x_recyclerview_tyno_rerun.networks.NewsApi
import com.example.padc_x_recyclerview_tyno_rerun.networks.responses.GetAllNewsResponse
import com.example.padc_x_recyclerview_tyno_rerun.utils.BASE_URL
import com.example.padc_x_recyclerview_tyno_rerun.utils.EM_NULL_NEWS_RESPONSE
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl: NewsDataAgent {
    private var mNewsApi : NewsApi? = null
    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

      mNewsApi =  retrofit.create(NewsApi::class.java)

    }
    override fun getAllNews(
        accessToken: String,
        onSuccess: (List<NewsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        val getAllNewsCall = mNewsApi?.getAllNews(accessToken)

        getAllNewsCall?.enqueue(object : Callback<GetAllNewsResponse>{
            override fun onFailure(call: Call<GetAllNewsResponse>, t: Throwable) {

                onFailure(t.message ?: EM_NULL_NEWS_RESPONSE)

            }

            override fun onResponse(
                call: Call<GetAllNewsResponse>,
                response: Response<GetAllNewsResponse>
            ) {
                   val getAllNewsResponse = response.body()
                if(getAllNewsResponse != null){
                    if(getAllNewsResponse.isResponseOk()){
                        getAllNewsResponse.data?.let{
                            onSuccess(it)
                        }
                    }
                    else{
                        onFailure(getAllNewsResponse.message)

                    }

                }else {
                    onFailure(EM_NULL_NEWS_RESPONSE)
                }

            }
        }

        )
    }

}