package com.example.note_kotlin.fragment

import com.example.note_kotlin.R
import com.example.note_kotlin.base.BaseFragment
import com.example.note_kotlin.databinding.FragmentCommonBinding

class WishListFragment : BaseFragment<FragmentCommonBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_common

    override fun initData() {
        mBinding?.tvTxt?.text = "Wishlists"
    }
}