package com.arseniy.hw1m4.ui.fragments

import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arseniy.hw1m4.ui.fragments.OnBoardViewPagerFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter(
    fragment: OnBoardFragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardViewPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}