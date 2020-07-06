package com.example.padc_x_recyclerview_tyno_rerun.networks.dataagents

import android.os.AsyncTask
import com.example.padc_x_recyclerview_tyno_rerun.networks.responses.GetAllNewsResponse
import com.example.padc_x_recyclerview_tyno_rerun.utils.BASE_URL
import com.example.padc_x_recyclerview_tyno_rerun.utils.EM_NULL_NEWS_RESPONSE
import com.example.padc_x_recyclerview_tyno_rerun.utils.GET_NEWS
import com.example.padc_x_recyclerview_tyno_rerun.utils.PARAM_ACCESS_TOKEN
import com.google.gson.Gson
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit

object OkHttpUrlConnectionDataAgentImpl:NewsDataAgent {
    private val mClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15,TimeUnit.SECONDS)
        .writeTimeout(15,TimeUnit.SECONDS)
        .build()


    override fun getAllNews(
        accessToken: String,
        onSuccess: (List<NewsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        GetNewsTask(mClient, mAccessToken = accessToken, onSuccess = onSuccess, onFailure = onFailure).execute()

    }
    class GetNewsTask(private val mOkHttpClient: OkHttpClient,
                      private val mAccessToken: String,private  val onSuccess: (List<NewsVO>) -> Unit,private val onFailure: (String) -> Unit):
            AsyncTask<Void, Void, GetAllNewsResponse>(){
        override fun doInBackground(vararg params: Void?): GetAllNewsResponse? {

            val formBody = FormBody.Builder()
                .add(PARAM_ACCESS_TOKEN, mAccessToken)
                .build()

            val request = Request.Builder()
                .url(BASE_URL + GET_NEWS)
                .post(formBody)
                .build()

            try {
                val response = mOkHttpClient.newCall(request).execute()
                if (response.isSuccessful) {
                    response.body?.let {
                        val responseString = it.string()
                        return Gson().fromJson<GetAllNewsResponse>(
                            responseString,
                            GetAllNewsResponse::class.java
                        )
                    }
                }
            } catch (e: Exception) {

            }
            return null
        }

        override fun onPostExecute(result: GetAllNewsResponse?) {
            super.onPostExecute(result)
            if(result != null){
                if(result.isResponseOk())
                {
                    result.data?.let{

                        onSuccess(it.toList())
                    }

                }
                else{
                  onFailure(result.message)
                }

            }

        }
        }
    }
