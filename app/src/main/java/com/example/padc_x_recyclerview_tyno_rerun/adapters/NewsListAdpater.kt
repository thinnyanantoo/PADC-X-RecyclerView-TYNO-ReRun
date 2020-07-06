package com.example.padc_x_recyclerview_tyno_rerun.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.padc_x_recyclerview_tyno_rerun.R
import com.example.padc_x_recyclerview_tyno_rerun.delegates.NewsItemDelegate
import com.example.padc_x_recyclerview_tyno_rerun.viewholders.BaseNewsViewHolder
import com.example.padc_x_recyclerview_tyno_rerun.viewholders.BaseViewHolder
import com.example.padc_x_recyclerview_tyno_rerun.viewholders.NewsSmallViewHolder
import com.example.padc_x_recyclerview_tyno_rerun.viewholders.NewsViewHolder
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO

class NewsListAdpater(delegate: NewsItemDelegate): BaseRecyclerAdapter<BaseNewsViewHolder,NewsVO>() {
    val mDelegate: NewsItemDelegate= delegate
    val VIEW_TYPE_LARGE = 2244
    val VIEW_TYPE_SMALL = 1122
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNewsViewHolder {
        when(viewType){
            VIEW_TYPE_LARGE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
            VIEW_TYPE_SMALL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.items_new_small,parent,false)
                    return NewsSmallViewHolder(view,mDelegate)

            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        when {
            position% 3 == 0 -> {
                return VIEW_TYPE_LARGE
            }
            else -> {
                return VIEW_TYPE_SMALL
            }
        }
    }



}