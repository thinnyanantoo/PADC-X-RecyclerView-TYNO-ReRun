package com.example.padc_x_recyclerview_tyno_rerun.viewholders

import android.view.View
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.padc_x_recyclerview_tyno_rerun.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import kotlinx.android.synthetic.main.items_new_small.view.*

class NewsSmallViewHolder(itemView: View,delegate: NewsItemDelegate) : BaseNewsViewHolder(itemView){
    var mDelegate:NewsItemDelegate = delegate

    init {
        itemView.setOnClickListener {
            mData?.let{
                mDelegate.onTapNewsItem()
            }
        }
    }

    override fun bindData(data: NewsVO) {
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.ivNewsImage)
        itemView.tvNewsHeadLine.text = data.title
        itemView.tvPublishedDate.text = data.publication?.postedDate
    }
}