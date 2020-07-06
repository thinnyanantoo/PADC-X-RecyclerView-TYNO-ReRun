package com.example.padc_x_recyclerview_tyno_rerun.data.models

import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO

interface NewsModel  {
    fun getAllNews(onSuccess: (List<NewsVO>) -> Unit,
                   onFailure : (String) -> Unit)

    fun getNewsById(newsId: Int)
}