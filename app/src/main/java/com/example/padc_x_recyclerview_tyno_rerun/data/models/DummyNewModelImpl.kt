package com.example.padc_x_recyclerview_tyno_rerun.data.models

import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO

object DummyNewModelImpl : BaseModel(), NewsModel{
    override fun getAllNews(onSuccess: (List<NewsVO>) -> Unit, onFailure: (String) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNewsById(newsId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}