package com.jihyun.kreamclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeFragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private var fragmentList: List<Fragment> = emptyList()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun setFragmentList(fragmentList: List<Fragment>) {
        this.fragmentList = fragmentList.toList()
        notifyDataSetChanged()
    }

}