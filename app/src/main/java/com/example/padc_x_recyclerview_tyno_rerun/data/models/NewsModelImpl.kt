package com.example.padc_x_recyclerview_tyno_rerun.data.models

import com.example.padc_x_recyclerview_tyno_rerun.networks.dataagents.NewsDataAgent
import com.example.padc_x_recyclerview_tyno_rerun.utils.DUMMY_ACCESS_TOKEN
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO

object NewsModelImpl : BaseModel(), NewsModel {

    override fun getAllNews(onSuccess: (List<NewsVO>) -> Unit,
                            onFailure: (String) -> Unit) {
        mDataAgent.getAllNews(DUMMY_ACCESS_TOKEN,onSuccess = {
            onSuccess.invoke(it)

        },onFailure = {
            onFailure.invoke(it)
        })


    }

    override fun getNewsById(newsId: Int) {
    }


}