package com.example.padc_x_recyclerview_tyno_rerun.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.padc_x_recyclerview_tyno_rerun.viewholders.BaseViewHolder
import java.util.Collections.addAll

abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> :RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = arrayListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
       holder.bindData(mData[position])

    }
    fun setNewData(data : MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    fun appendNewData(data : List<W>){
       mData.addAll(data)
        notifyDataSetChanged()
    }
}


