package com.example.padc_x_recyclerview_tyno_rerun.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_x_recyclerview_tyno_rerun.R
import com.example.padc_x_recyclerview_tyno_rerun.adapters.NewsListAdpater
import com.example.padc_x_recyclerview_tyno_rerun.data.models.NewsModel
import com.example.padc_x_recyclerview_tyno_rerun.data.models.NewsModelImpl
import com.example.padc_x_recyclerview_tyno_rerun.delegates.NewsItemDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity(),NewsItemDelegate{


    val mNewsModel: NewsModel = NewsModelImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = NewsListAdpater(this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val gridLayoutManager = GridLayoutManager(this,3)

        rvNews.layoutManager = linearLayoutManager

        rvNews.adapter = adapter

        mNewsModel.getAllNews(
            onSuccess = {
                //Bind data with Recycler View
              //  val newsList = it
                adapter.setNewData(it.toMutableList())
            },
            onFailure = {
                //Show Error Message
                showSnackbar(it)
            }
        )


    }

    override fun onTapNewsItem() {
        startActivity(
            NewsDetailActivity.newIntent(this)
        )
    }


}
