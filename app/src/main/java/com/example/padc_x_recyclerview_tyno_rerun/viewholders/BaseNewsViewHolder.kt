package com.example.padc_x_recyclerview_tyno_rerun.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.padc_x_recyclerview_tyno_rerun.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import kotlinx.android.synthetic.main.items_new_small.view.*

abstract class BaseNewsViewHolder (itemView : View):BaseViewHolder<NewsVO>(itemView) {

}