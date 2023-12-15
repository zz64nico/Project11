package com.example.note_kotlin.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.note_kotlin.R
import com.example.note_kotlin.entity.Cabins

class HomeAdapter(context: Context, var iHomeListener: IHomeListener):BaseQuickAdapter<Cabins,BaseViewHolder>(R.layout.item) {
    override fun convert(holder: BaseViewHolder, item: Cabins) {
        Glide.with(context).load(item.picUrl).into(holder.getView(R.id.image));
        holder.setText(R.id.tv_title,item.title)
        holder.setText(R.id.tv_des,item.des)
        holder.setText(R.id.tv_start,item.star)
        holder.setText(R.id.tv_night,item.money)
        holder.getView<View>(R.id.card_view).setOnClickListener {
            if (iHomeListener != null) {
                iHomeListener!!.onHomeClick(item)
            }
        }
    }
}