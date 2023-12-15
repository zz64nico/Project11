package com.example.note_kotlin.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.note_kotlin.R
import com.example.note_kotlin.entity.Cabins

class TripsAdapter: BaseQuickAdapter<Cabins, BaseViewHolder>(R.layout.item_trips) {
    override fun convert(holder: BaseViewHolder, item: Cabins) {
        Glide.with(context).load(item.picUrl).into(holder.getView(R.id.image));
        holder.setText(R.id.tv_title,item.title)
        holder.setText(R.id.tv_des,item.des)

    }
}