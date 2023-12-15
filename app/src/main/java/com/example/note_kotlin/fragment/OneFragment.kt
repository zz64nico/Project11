package com.example.note_kotlin.fragment

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.note_kotlin.MyItemDecoration
import com.example.note_kotlin.R
import com.example.note_kotlin.adapter.HomeAdapter
import com.example.note_kotlin.adapter.IHomeListener
import com.example.note_kotlin.base.BaseFragment
import com.example.note_kotlin.databinding.FragmentOneBinding
import com.example.note_kotlin.entity.Cabins
import com.example.note_kotlin.ui.DetailActivity

class OneFragment:BaseFragment<FragmentOneBinding>(),IHomeListener {

    lateinit var homeAdapter: HomeAdapter
    override val layoutId: Int
        get() = R.layout.fragment_one

    override fun initData() {
        homeAdapter = HomeAdapter(requireActivity(),this)
        mBinding!!.rlOne.layoutManager = LinearLayoutManager(requireActivity())
        mBinding!!.rlOne.addItemDecoration(MyItemDecoration(10))
        mBinding!!.rlOne.adapter = homeAdapter;
        var  list = ArrayList<Cabins>()
        list.add(Cabins("https://dimg04.c-ctrip.com/images/200u0500000013l6524D3_R_600_400_R5_D.jpg","Hanting Hotel","Single room","178 Shuangfeng Road, Yubei District, Chongqing","4.5","50","Phoenix International Hotel was developed and constructed by Dazhou Phoenix International Hotel Co., LTD. In the early stage, Sichuan Jinjiang Tourism Hotel Management Company was entrusted to build and consult management. As the first luxury hotel for business and conference in Dazhou according to the national five-star standard, it has been highly valued by Dazhou Municipal Committee and Government and is one of the key construction projects in Dazhou City."))
        list.add(Cabins("https://dimg04.c-ctrip.com/images/200n0c00000067iut3C93_W_1080_808_R5_D.jpg","Happy Hotel","Single room","178 Shuangfeng Road, Yubei District, Chongqing","4.8","48","Phoenix International Hotel was developed and constructed by Dazhou Phoenix International Hotel Co., LTD. In the early stage, Sichuan Jinjiang Tourism Hotel Management Company was entrusted to build and consult management. As the first luxury hotel for business and conference in Dazhou according to the national five-star standard, it has been highly valued by Dazhou Municipal Committee and Government and is one of the key construction projects in Dazhou City."))
        list.add(Cabins("https://ak-d.tripcdn.com/images/0202e120008h6nh9y0C9F_R_600_400_R5_D.jpg","7 Day Hotel","Double room","178 Shuangfeng Road, Yubei District, Chongqing","4.6","64","Phoenix International Hotel was developed and constructed by Dazhou Phoenix International Hotel Co., LTD. In the early stage, Sichuan Jinjiang Tourism Hotel Management Company was entrusted to build and consult management. As the first luxury hotel for business and conference in Dazhou according to the national five-star standard, it has been highly valued by Dazhou Municipal Committee and Government and is one of the key construction projects in Dazhou City."))
        list.add(Cabins("https://pic.quanjing.com/95/61/QJ9101053716.jpg","Double happiness Hotel","Double room","178 Shuangfeng Road, Yubei District, Chongqing","4.9","43","Phoenix International Hotel was developed and constructed by Dazhou Phoenix International Hotel Co., LTD. In the early stage, Sichuan Jinjiang Tourism Hotel Management Company was entrusted to build and consult management. As the first luxury hotel for business and conference in Dazhou according to the national five-star standard, it has been highly valued by Dazhou Municipal Committee and Government and is one of the key construction projects in Dazhou City."))
        homeAdapter.setNewData(list)
        homeAdapter.notifyDataSetChanged()
    }

    override fun onHomeClick(cabins: Cabins) {
        var intent = Intent(requireActivity(),DetailActivity::class.java)
        intent.putExtra("cabins",cabins)
        startActivity(intent)

    }
}