package com.example.note_kotlin.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note_kotlin.App
import com.example.note_kotlin.MyItemDecoration
import com.example.note_kotlin.R
import com.example.note_kotlin.adapter.TripsAdapter
import com.example.note_kotlin.base.BaseFragment
import com.example.note_kotlin.databinding.FragmentCommonBinding
import com.example.note_kotlin.databinding.FragmentTripsBinding

class TripsFragment : BaseFragment<FragmentTripsBinding>(){
    lateinit var tripsAdapter: TripsAdapter
    override val layoutId: Int
        get() = R.layout.fragment_trips

    override fun initData() {
        mBinding?.tvTxt?.text = "Trips"
        tripsAdapter = TripsAdapter();
        mBinding!!.rlTrips.layoutManager = LinearLayoutManager(requireActivity())
        mBinding!!.rlTrips.addItemDecoration(MyItemDecoration(10))
        mBinding!!.rlTrips.adapter = tripsAdapter;
        tripsAdapter.setNewData(App.cabinList)
        tripsAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        tripsAdapter.setNewData(App.cabinList)
        tripsAdapter.notifyDataSetChanged()
    }
}