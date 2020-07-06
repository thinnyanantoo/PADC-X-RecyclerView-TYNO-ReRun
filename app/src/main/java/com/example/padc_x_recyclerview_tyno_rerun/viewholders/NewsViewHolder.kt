package com.example.padc_x_recyclerview_tyno_rerun.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.padc_x_recyclerview_tyno_rerun.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(itemView: View,delegate: NewsItemDelegate):BaseNewsViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.onTapNewsItem()
        }
    }

    override fun bindData(data: NewsVO) {
         Glide.with(itemView.context)
             .load(data.heroImage)
             .into(itemView.ivNewsImage)

        itemView.tvNewsHeadLine.text = data.title
        itemView.tvPublishedDate.text = data.publication?.postedDate
        itemView.tvPublication.text = data.publication?.publicationName


    }
}