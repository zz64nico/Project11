package com.example.note_kotlin.ui

import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.bonusapp.adapter.MainAdapter
import com.example.note_kotlin.R
import com.example.note_kotlin.base.BaseActivity
import com.example.note_kotlin.databinding.ActivityHomeBinding
import com.example.note_kotlin.fragment.ChatFragment
import com.example.note_kotlin.fragment.ExploreFragment
import com.example.note_kotlin.fragment.MeFragment
import com.example.note_kotlin.fragment.TripsFragment
import com.example.note_kotlin.fragment.WishListFragment


class HomeActivity :BaseActivity<ActivityHomeBinding>(), RadioGroup.OnCheckedChangeListener{
    override val layoutId: Int
        get() = R.layout.activity_home

    override fun initData() {
        mBinding?.radioGroup?.setOnCheckedChangeListener(this)
        val fragments: MutableList<Fragment> = ArrayList()
        fragments.add(ExploreFragment())
        fragments.add(WishListFragment())
        fragments.add(TripsFragment())
        fragments.add(ChatFragment())
        fragments.add(MeFragment())
        val adapter = MainAdapter(supportFragmentManager, fragments)
        mBinding?.mainPager?.setOffscreenPageLimit(2)
        mBinding?.mainPager?.setAdapter(adapter)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            R.id.tab_home->{
                mBinding?.mainPager?.setCurrentItem(0,true);
            }
            R.id.tab_analyse->{
                mBinding?.mainPager?.setCurrentItem(1,true);
            }
            R.id.tab_jihua->{
                mBinding?.mainPager?.setCurrentItem(2,true);
            }
            R.id.tab_circle->{
                mBinding?.mainPager?.setCurrentItem(3,true);
            }
            R.id.tab_me->{
                mBinding?.mainPager?.setCurrentItem(4,true);
            }
        }
    }
}