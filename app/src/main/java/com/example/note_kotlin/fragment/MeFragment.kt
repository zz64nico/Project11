package com.example.note_kotlin.fragment

import android.content.Intent
import android.os.Process
import android.view.View
import com.bumptech.glide.Glide
import com.example.note_kotlin.App
import com.example.note_kotlin.LoginActivity
import com.example.note_kotlin.R
import com.example.note_kotlin.base.BaseFragment
import com.example.note_kotlin.databinding.FragmentMeBinding
import java.text.SimpleDateFormat
import java.util.Date

class MeFragment:BaseFragment<FragmentMeBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_me

    override fun initData() {
        mBinding?.tvTxt?.text = "Profile"
        mBinding?.tvLoginIn?.setOnClickListener {
            if (App.user!=null){
                try {
                    //正常退出
                    Process.killProcess(Process.myPid())
                    System.exit(0)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return@setOnClickListener
            }
            startActivity(Intent(requireActivity(),LoginActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        if (App.user!=null){
            mBinding?.ll?.visibility = View.VISIBLE
            mBinding?.tvLoginIn?.text = "Log out"
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")

            val currentDate = Date() //获取当前日期时间对象


            val formattedDate: String = dateFormat.format(currentDate) //将日期对象按指定格式进行格式化


            if (App.user!!.photoUrl!=null){
                Glide.with(requireActivity()).load(App.user!!.photoUrl).into(mBinding?.imhHead!!)
            }else{
                Glide.with(requireActivity()).load(R.drawable.head_default).into(mBinding?.imhHead!!)
            }
            mBinding?.tvEmail?.text = App.user!!.email
//            mBinding?.tvName?.text = App.user!!.displayName
            mBinding?.tvTime?.text = "Since" +formattedDate

        }else{
            mBinding?.ll?.visibility = View.GONE
            mBinding?.tvLoginIn?.text = "Log in"
        }
    }
}