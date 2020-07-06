package com.example.padc_x_recyclerview_tyno_rerun.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.padc_x_recyclerview_tyno_rerun.R

class NewsDetailActivity :BasicActivity(){

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, NewsDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
    }
}
