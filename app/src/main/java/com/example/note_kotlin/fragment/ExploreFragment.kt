package com.example.note_kotlin.fragment


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.note_kotlin.R
import com.example.note_kotlin.base.BaseFragment
import com.example.note_kotlin.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class ExploreFragment:BaseFragment<FragmentExploreBinding>() {
    //选中的Tab图片

    //未选中的Tab图片
    private val unSelectTabRes = intArrayOf(
        R.drawable.unhome,
        R.drawable.unfire,
        R.drawable.uncard,
        R.drawable.uncity,
        R.drawable.unumbrella
    )

    //选中的Tab图片
    private val selectTabRes = intArrayOf(
        R.drawable.home,
        R.drawable.fire,
        R.drawable.card,
        R.drawable.city,
        R.drawable.umbrella
    )



    //Tab标题
    private val title = arrayOf("Cabins","Tending", "Play", "City", "BeachFront")



    override val layoutId: Int
        get() = R.layout.fragment_explore

    override fun initData() {
        //使用适配器将ViewPager与Fragment绑定在一起
        mBinding!!.mainPager.setAdapter(MyFragmentPagerAdapter(childFragmentManager));
        //将TabLayout与ViewPager绑定
        mBinding!!.tabLayout.setupWithViewPager(mBinding!!.mainPager);
        for (i in 0 until title.size) {
            if (i == 0) {
                mBinding!!.tabLayout.getTabAt(0)?.setIcon(selectTabRes[0])
            } else {
                mBinding!!.tabLayout.getTabAt(i)?.setIcon(unSelectTabRes[i])
            }
        }
        initListener()
    }

    private fun initListener() {
        //TabLayout切换时导航栏图片处理
        mBinding?.tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) { //选中图片操作
                for (i in 0 until title.size) {
                    if (tab ===  mBinding?.tabLayout!!.getTabAt(i)) {
                        mBinding?.tabLayout!!.getTabAt(i)!!.setIcon(selectTabRes[i])
                        mBinding?.mainPager!!.currentItem = i
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) { //未选中图片操作
                for (i in 0 until title.size) {
                    if (tab ===  mBinding?.tabLayout!!.getTabAt(i)) {
                        mBinding?.tabLayout!!.getTabAt(i)!!.setIcon(unSelectTabRes[i])
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    //自定义适配器
    class MyFragmentPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
        private val title = arrayOf("Cabins","Tending", "Play", "City", "BeachFront")
        override fun getItem(position: Int): Fragment {
            if (position == 1) {
                return OneFragment() //
            } else if (position == 2) {
                return OneFragment() //
            } else if (position == 3) {
                return OneFragment() //
            } else if (position == 4) {
                return OneFragment() //
            }
            return OneFragment() //首页
        }

        override fun getCount(): Int {
            return title.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return title.get(position)
        }
    }
}