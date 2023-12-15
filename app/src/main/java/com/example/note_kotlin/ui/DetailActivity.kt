package com.example.note_kotlin.ui

import com.bumptech.glide.Glide
import com.example.note_kotlin.App
import com.example.note_kotlin.R
import com.example.note_kotlin.base.BaseActivity
import com.example.note_kotlin.databinding.ActivityDetailBinding
import com.example.note_kotlin.entity.Cabins

class DetailActivity:BaseActivity<ActivityDetailBinding>() {
    lateinit var cabins:Cabins;
    override val layoutId: Int
        get() = R.layout.activity_detail

    override fun initData() {
        cabins = intent.getSerializableExtra("cabins") as  Cabins;
        if (cabins!=null){
            Glide.with(this).load(cabins.picUrl).into(mBinding?.image!!)
            mBinding!!.tvTitle.text = cabins.title
            mBinding!!.tvStart.text = cabins.star
            mBinding!!.tvAddress.text = cabins.address
            mBinding!!.tvNight.text = cabins.money
            mBinding!!.tvDetail.text = cabins.detail

        }
        mBinding?.back?.setOnClickListener {
            finish()
        }
        mBinding?.tvReserve?.setOnClickListener {
            App.cabinList.add(cabins)
        }
    }
}